package com.android.product.domain.model.response

import java.io.Serializable

data class Product(
    private val brand: String?,
    private val category: String?,
    private val description: String?,
    private val discountPercentage: Double?,
    private val id: Int?,
    private val images: List<String>?,
    private val price: Int?,
    private val rating: Double?,
    private  val stock: Int?,
    private val thumbnail: String?,
    private val title: String?
): Serializable