package ru.pauri.app.utils

import android.system.ErrnoException
import com.arcsinus.murzin.andrey.arcsinus.R
import com.arcsinus.murzin.andrey.arcsinus.presentation.base.CanShowMessage
import com.arcsinus.murzin.andrey.arcsinus.utils.HttpErrorCodeParser
import com.arcsinus.murzin.andrey.arcsinus.utils.delegate.ResourceDelegate
import io.reactivex.exceptions.CompositeException
import io.reactivex.plugins.RxJavaPlugins
import okhttp3.internal.http2.StreamResetException
import retrofit2.HttpException
import java.lang.ref.WeakReference
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject
import javax.net.ssl.SSLException
import javax.net.ssl.SSLHandshakeException

class ErrorHandler @Inject constructor(
    private val codeParser: HttpErrorCodeParser,
    private val resourceRepository: ResourceDelegate
) {

    private val errorActionMap = mutableMapOf<Class<out Throwable>, (Throwable) -> Unit>()

    private var errorView: WeakReference<CanShowMessage>? = null

    fun attachView(view: CanShowMessage) {
        errorView = WeakReference(view)
    }

    fun handleError(throwable: Throwable?) {
        when (throwable) {
            is CompositeException -> {
                throwable.exceptions.forEach { handleError(it) }
                return
            }
            else -> {
                throwable?.let {
                    val action = errorActionMap[it.javaClass]
                    if (action != null) {
                        action.invoke(it)
                    } else {
                        errorView?.get()?.showMessage(resourceRepository.getString(R.string.error_unknown))
                    }
                    it.printStackTrace()
                }
            }
        }
    }

    init {
        RxJavaPlugins.setErrorHandler {

        }
    }

    private val unknownHostErrorHandler: (Throwable) -> Unit = {
        errorView?.get()?.showMessage(resourceRepository.getString(R.string.error_no_internet))
    }

    private val socketTimeoutErrorHandler: (Throwable) -> Unit = {
        errorView?.get()?.showMessage(resourceRepository.getString(R.string.error_unable_load_data))
    }

    private val httpErrorHandler: (Throwable) -> Unit = {
        if ((it as HttpException).code() == 500) {
            errorView?.get()?.showMessage(resourceRepository.getString(R.string.error_service_not_available))
        } else {
            parseHttpCodeJson(it)?.let { str ->
                errorView?.get()?.showMessage(str)
            } ?: run {
                errorView?.get()?.showMessage(resourceRepository.getString(R.string.error_unknown))
            }
        }
    }

    init {
        addError(HttpException::class.java, httpErrorHandler)
        addError(ConnectException::class.java, unknownHostErrorHandler)
        addError(ErrnoException::class.java, unknownHostErrorHandler)
        addError(retrofit2.adapter.rxjava2.HttpException::class.java, httpErrorHandler)
        addError(SocketTimeoutException::class.java, socketTimeoutErrorHandler)
        addError(UnknownHostException::class.java, unknownHostErrorHandler)
        addError(ConnectException::class.java, unknownHostErrorHandler)
        addError(StreamResetException::class.java, unknownHostErrorHandler)
        addError(SSLHandshakeException::class.java, unknownHostErrorHandler)
        addError(SSLException::class.java, unknownHostErrorHandler)
    }

    fun addError(clazz: Class<out Throwable>, handleAction: (Throwable) -> Unit) {
        errorActionMap[clazz] = handleAction
    }

    private fun parseHttpCodeJson(httpException: HttpException): String? {
        return httpException.response().errorBody()
            ?.use {
                return codeParser.parseCode(it)
            }
    }
}
