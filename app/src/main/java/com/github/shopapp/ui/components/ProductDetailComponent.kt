package com.github.shopapp.ui.components

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.github.shopapp.data.Product
import com.github.shopapp.ui.theme.Typography

@Composable
fun ProductDetailComponent(product: Product, modifier: Modifier) {
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text= stringResource(product.name), style = Typography.titleLarge)
        Image(painter = painterResource(product.image), contentDescription = "image product")
        Divider(
            modifier = Modifier.padding(vertical = 8.dp),
            thickness = 2.dp,
            color = Color.Red
        )
        Row(modifier = Modifier.fillMaxWidth().padding(24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "${product.price}€", style = Typography.titleLarge, color= if(product.strock>0) Color.Green else Color.Red)
            Text(text = "${product.strock}", style = Typography.titleLarge, color = Color.Blue)
            Text(text = if(product.strock>0) "En Stock" else "Sin Stock",style = Typography.titleLarge)
        }
    }

}