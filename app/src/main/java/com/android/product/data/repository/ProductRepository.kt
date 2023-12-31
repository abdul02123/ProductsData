package com.android.product.data.repository

import com.android.product.data.remote.ProductApi
import com.android.product.domain.model.response.ProductListResponse
import retrofit2.Response
import javax.inject.Inject

class ProductRepository @Inject constructor(private val productApi: ProductApi) {

    suspend fun getProductListRecord(): Response<ProductListResponse>? {
        return productApi.getProductList()

    }
}