package com.android.myapplication.presentation.product

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.myapplication.data.repository.ProductRepository
import com.android.myapplication.domain.model.response.ProductListResponse
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductViewModel @Inject constructor(private val productRepository: ProductRepository) :
    ViewModel() {

    var productsResult: MutableLiveData<ProductListResponse>? = null

    fun getAllProducts() {
        viewModelScope.launch {
            val result = productRepository.getProductListRecord()
            if (result?.isSuccessful == true) {
                productsResult?.value = result.body()
            }
        }
    }

}