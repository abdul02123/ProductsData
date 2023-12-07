package com.android.myapplication.presentation.product

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class ProductActivity : AppCompatActivity() {

//    private val  productViewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        initObserver()
//        getShowProductList()
    }

    /*private fun initObserver(){
        productViewModel.productsResult?.observe(this){
            when(it){

            }
        }
    }

    private fun getShowProductList(){
        if (NetworkUtil.isNetworkAvailable(applicationContext)){
            productViewModel.getAllProducts()
        }
    }*/
}