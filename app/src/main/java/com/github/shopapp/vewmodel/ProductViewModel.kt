package com.github.shopapp.vewmodel

import androidx.lifecycle.ViewModel
import com.github.shopapp.data.ProductDataSource
import com.github.shopapp.model.ProductState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProductViewModel: ViewModel() {
    val listProducts = ProductDataSource.loadlistproduct()

    private val _listState = MutableStateFlow(ProductState(listProductsState = listProducts))
    val listState : StateFlow<ProductState> = _listState

    public fun addChangeAmount(productId: Int){
        val product = listProducts.find { it.id == productId }
        product?.let {
            val updateAmount = _listState.value.totalAmount + it.price
            _listState.value = _listState.value.copy(totalAmount = updateAmount)
        }
    }




}