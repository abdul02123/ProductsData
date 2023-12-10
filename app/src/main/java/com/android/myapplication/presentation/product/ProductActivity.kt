package com.android.myapplication.presentation.product

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.android.myapplication.utils.NetworkUtil
import com.example.myapplication.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductActivity : AppCompatActivity() {

    private val  productViewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initObserver()
        getShowProductList()
    }

    private fun initObserver(){
        productViewModel.productsResult?.observe(this){
            when(it){

            }
        }
    }

    private fun getShowProductList(){
        if (NetworkUtil.isNetworkAvailable(applicationContext)){
            productViewModel.getAllProducts()
        }
    }
}