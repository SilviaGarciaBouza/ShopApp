package com.github.shopapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Product(val id: Int, @StringRes val name:Int, @DrawableRes val image:Int, val price: Double, val strock: Int)

