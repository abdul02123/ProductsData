package com.android.product.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.product.domain.model.response.Product
import com.example.myapplication.databinding.ItemProductBinding

class ProductListAdapter(
    private val productList: ArrayList<Product>, private val onClick: (product: Product) ->Unit
) : RecyclerView.Adapter<ProductListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val product = productList[position]
        holder.bind(product)
    }

    inner class MyViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.tvBrand.text = product.brand
            binding.tvCategory.text = product.category
            binding.tvDescription.text = product.description
            binding.root.setOnClickListener{
                onClick.invoke(product)
            }
        }
    }
}