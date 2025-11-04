package com.github.shopapp.vewmodel

import androidx.lifecycle.ViewModel
import com.github.shopapp.data.Product
import com.github.shopapp.data.ProductDataSource
import com.github.shopapp.model.ProductState
import com.github.shopapp.navigation.ProductNav
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProductViewModel: ViewModel() {
    val listProducts = ProductDataSource.loadlistproduct()

    private val _listState = MutableStateFlow(ProductState(listProductsState = listProducts))
    val listState : StateFlow<ProductState> = _listState

//init recuerda hacerlo

    public fun addChangeAmount(productId: Int){
        val product = listProducts.find { it.id == productId }
        product?.let {
            val updateAmount = _listState.value.totalAmount + it.price
            _listState.value = _listState.value.copy(totalAmount = updateAmount)
        }
    }
//TODO
    public fun lessChangeAmount(productId: Int){
        val product = listProducts.find { it.id == productId }
        product?.let {
            val updateAmount:Double = if ( (_listState.value.totalAmount - it.price) >= 0.0) _listState.value.totalAmount - it.price else 0.0
            _listState.value = _listState.value.copy(totalAmount = updateAmount)
        }
    }
    public fun amountCero(){
        _listState.value=_listState.value.copy(totalAmount = 0.0)
    }
    fun addTocart(product: Product, quantity:Int){
        val listItems = if(_listState.value.listProductsState.any{it.id==product.id}){
            _listState.value.listProductsState.map { if(it.id ==product.id){
                it.copy(strock = it.strock +quantity)
            }else{
                it
            }
            }
        }else{
          //  val newItem= Product(id=product.id, ....)
            _listState.value.listProductsState + product // hay q pasarlo a una list
         //   _listState.value = _listState.value.copy(listProductsState= listItems)
        }
    }

    fun removeProduct(id:Int){
        _listState.value= _listState.value.copy(listProductsState= _listState.value.listProductsState.filter { it.id!=id })
    }

//public fun reduceProduct(id:Int){
//    val product=
//    _listState.value=_listState.value.find(listProducts.map { e -> if(e.id=id) e.strock -1 else e.strock })
//}

}

//any all si todos cumplen, count sum + esta añadiendo con una lista
//si la hacemos mutable hay q volver a hacerla inmutable el toList() para q nadie acceda a ella hay q acceder a copy , para q las responsabilidades q den totalmente separada laos elementos del vm tienen q ser inmutable