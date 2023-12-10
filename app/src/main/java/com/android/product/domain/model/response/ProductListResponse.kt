package com.android.product.domain.model.response

import java.io.Serializable

data class ProductListResponse(
     val limit: Int?,
     val products: ArrayList<Product>,
     val skip: Int?,
     val total: Int?
): Serializable