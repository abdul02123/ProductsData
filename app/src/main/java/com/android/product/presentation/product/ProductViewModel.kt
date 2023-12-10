package com.android.product.presentation.product

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.product.data.repository.ProductRepository
import com.android.product.domain.model.response.ProductListResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
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