package com.android.myapplication.data.repository

import com.android.myapplication.data.remote.ProductApi
import com.android.myapplication.domain.model.response.ProductListResponse
import retrofit2.Response
import javax.inject.Inject

class ProductRepository @Inject constructor(private val productApi: ProductApi) {

    suspend fun getProductListRecord(): Response<ProductListResponse>? {
        return productApi.getProductList()

    }
}