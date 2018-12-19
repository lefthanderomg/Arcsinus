package com.arcsinus.murzin.andrey.arcsinus.utils.ext

import java.lang.ref.WeakReference

fun <T> T.weak() = WeakReference(this)
