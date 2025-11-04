package com.github.shopapp.model

import com.github.shopapp.data.Product

data class ProductState(
   val listProductsState : List<Product> = emptyList(),
   val totalAmount: Double=0.0
)
