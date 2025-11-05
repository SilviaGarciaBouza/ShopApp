package com.github.shopapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import com.github.shopapp.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class Prueba (@DrawableRes val image: Int, @StringRes val name: Int)

object LP{
    fun load():List<Prueba>{
        return listOf(
            Prueba(R.drawable.onions, R.string.product_onions)

        )
    }
}

data class PState(val lit: List<Product> = emptyList())

class v : ViewModel(){
    val list= LP.load()

     private val _st = MutableStateFlow(PsState(lit=list))
    val st: StateFlow<PsState>=_st

init{


}
}