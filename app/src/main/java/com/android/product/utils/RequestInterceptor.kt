package com.android.product.utils.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Inject

class RequestInterceptor @Inject constructor() {
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    fun getInterceptor(): OkHttpClient{
        val client = OkHttpClient.Builder()
        client.addInterceptor(Interceptor { chain ->
            val request = chain.request().newBuilder()
            request.addHeader("auth", "354544")
            chain.proceed(request.build())
        })

//        if (BuildConfig.DEBUG){
            client.addInterceptor(loggingInterceptor)
//        }

        return client.build()
    }
}
