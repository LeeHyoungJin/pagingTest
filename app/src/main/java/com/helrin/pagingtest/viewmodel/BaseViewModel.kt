package com.helrin.tabling.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel(), LifecycleObserver {
    val TAG: String = javaClass.simpleName

    suspend fun <T> runDataLoading(block: suspend () -> T) {
        try {
            block()
        } catch (e: Exception) {
//            L.e(TAG,"erroe = ${e.message}")
        }
    }
}
