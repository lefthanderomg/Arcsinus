package com.arcsinus.murzin.andrey.arcsinus

import android.support.v4.app.Fragment
import com.arcsinus.murzin.andrey.arcsinus.presentation.feature.search.view.SearchFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object OnSearchScreen : SupportAppScreen() {
        override fun getFragment(): Fragment = SearchFragment()
    }
}