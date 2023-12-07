package com.android.myapplication.domain.model.response

import java.io.Serializable

data class ProductListResponse(
    private val limit: Int?,
    private val products: List<Product>?,
    private val skip: Int?,
    private val total: Int?
): Serializable