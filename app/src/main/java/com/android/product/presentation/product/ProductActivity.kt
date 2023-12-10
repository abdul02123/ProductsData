package com.android.product.presentation.product

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.product.domain.model.response.Product
import com.android.product.domain.model.response.ProductListResponse
import com.android.product.presentation.adapter.ProductListAdapter
import com.android.product.utils.NetworkResult
import com.android.product.utils.NetworkUtil
import com.android.product.utils.showToast
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val productViewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initObserver()
        getShowProductList()
    }

    private fun initObserver() {
        productViewModel.productsResult.observe(this) {
            when (it) {
                is NetworkResult.Success -> {
                    it.result?.apply {
                        showProductList(products)
                    }
                }

                is NetworkResult.Error -> {
                    showToast()
                }
            }
        }
    }

    private fun getShowProductList() {
        if (NetworkUtil.isNetworkAvailable(applicationContext)) {
            productViewModel.getAllProducts()
        }
    }

    private fun showProductList(productList: ArrayList<Product>) {
        val productListAdapter = ProductListAdapter(productList, ::onClick)
        binding.recyclerView.adapter = productListAdapter

    }

    private fun onClick(product: Product){
        showToast(product.brand?:"")
    }


}