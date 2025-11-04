package com.github.shopapp.ui.screeens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.github.shopapp.data.Product
import com.github.shopapp.ui.components.ListComponent
import com.github.shopapp.ui.components.TipAppBar

@Composable
fun ListScreen(amount: Double,listProducts: List<Product>, onBackClick:()->Unit,onclick:(Int)->Unit,onclickamount: (Int)->Unit) {
    Scaffold(
        topBar ={ TipAppBar(amount=amount,modifier = Modifier, false, onBackClick,{})}
    ) {
        paddingValues ->
        ListComponent(listProducts, Modifier.padding(paddingValues), {index -> onclick(index)},{index -> onclickamount(index)})
    }
}