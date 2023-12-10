package com.android.product.data.remote

import com.android.product.domain.model.response.ProductListResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProductApi {

    @GET("products")
    suspend fun getProductList(): Response<ProductListResponse>
}