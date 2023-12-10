package com.android.product.domain.model.response

import java.io.Serializable

data class Product(
     var brand: String? = null,
     var category: String?= null,
     var description: String?= null,
     var discountPercentage: Double?= null,
     var id: Int?= null,
     var images: List<String>?= null,
     var price: Int?= null,
     var rating: Double?= null,
     var stock: Int?= null,
     var thumbnail: String?= null,
     var title: String?= null
): Serializable