package com.github.shopapp.data

import androidx.annotation.DrawableRes

data class CardItem(

    val id: Int,
    val title: String,
    @DrawableRes val image: Int = 0,
    val price: Double,
    var quantity: Int = 1
)