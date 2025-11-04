package com.github.shopapp.ui.screeens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.github.shopapp.ui.components.BuyComponent
import com.github.shopapp.ui.components.TipAppBar

@Composable
fun BuyScreen(onCero:()->Unit,amount:Double,price:Double, ovback:()->Unit) {
    Scaffold(
        topBar ={ TipAppBar(onb={},amount=amount,modifier = Modifier, true, ovback,{})}
    ) { paddingValues ->
        BuyComponent({onCero()},price, Modifier.padding(paddingValues))

    }
}