package com.android.product.utils

sealed class NetworkResult<T>(val result: T? = null, val message: String? = null) {
    class Success<T>(result: T? = null) : NetworkResult<T>(result)
    class Error<T>(result: T? = null, message: String? = null) : NetworkResult<T>(result, message)
}


