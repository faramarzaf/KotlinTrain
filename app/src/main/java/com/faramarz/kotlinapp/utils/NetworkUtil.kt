package com.faramarz.kotlinapp.utils

import android.content.Context
import android.net.ConnectivityManager


class NetworkUtil {

    object checkConnection {

        fun isOnline(context: Context): Boolean {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfo = connectivityManager.activeNetworkInfo
            return netInfo != null && netInfo.isConnected
        }

    }


}