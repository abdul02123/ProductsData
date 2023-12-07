package com.android.myapplication.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

object NetworkUtil {

    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?

        connectivityManager?.let {
            val activeNetwork: NetworkInfo? = it.activeNetworkInfo
            return activeNetwork != null && activeNetwork.isConnected
        }

        return false
    }
}