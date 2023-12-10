package com.android.product.presentation.product

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.product.data.repository.ProductRepository
import com.android.product.domain.model.response.ProductListResponse
import com.android.product.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class ProductViewModel @Inject constructor(private val productRepository: ProductRepository) :
    ViewModel() {

    var productsResult = MutableLiveData<NetworkResult<ProductListResponse>>()

    fun getAllProducts() {
        viewModelScope.launch {
            val result = productRepository.getProductListRecord()
            if (result?.isSuccessful == true) {
                productsResult.value = NetworkResult.Success(result.body())
            }else{
                productsResult.value = NetworkResult.Error(message = result?.errorBody().toString())
            }
        }
    }

}