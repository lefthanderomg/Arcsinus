package com.arcsinus.murzin.andrey.arcsinus.utils.delegate

import android.app.Activity
import android.widget.Toast
import java.lang.ref.WeakReference

class ToastDelegate(private val activity: WeakReference<out Activity>) {

    fun showMessage(message: String) {
        activity.get()?.let {
            Toast.makeText(it, message, Toast.LENGTH_SHORT).show()

        }
    }
}

