package com.github.shopapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.github.shopapp.R

object ProductDataSource {
    fun loadlistproduct():List<Product>{
        return listOf(
            Product(1, R.string.product_onions, R.drawable.onions, 1.1, 30),
            Product(2, R.string.product_coke, R.drawable.coke, 2.2, 60),
            Product(3, R.string.product_lemon, R.drawable.lemon, 3.3, 30),
            Product(4, R.string.product_protein, R.drawable.protein, 4.4, 90),
            Product(5, R.string.product_potatoes, R.drawable.potatoes, 15.5, 30),
            Product(6, R.string.product_milk, R.drawable.milk, 10.1, 37),
            Product(7, R.string.product_mulberry, R.drawable.mulberry, 1.19, 30),
            Product(8, R.string.product_rice, R.drawable.rice, 18.1, 80),
            Product(9, R.string.product_strawberry, R.drawable.strawberry, 1.19, 300),
            Product(10, R.string.product_nescafe, R.drawable.nescafe, 17.1, 50)

        )
    }
}
