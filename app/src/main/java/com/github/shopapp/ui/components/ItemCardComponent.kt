package com.github.shopapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.github.shopapp.data.Product

@Composable
fun ItemCardComponent(product: Product, onclick: (Int)->Unit, onclickamount: (Int)->Unit, onclicklessamount: (Int)->Unit) {
    var quantity by rememberSaveable { mutableStateOf(0) }

    Card(modifier = Modifier.fillMaxSize().height(100.dp).clickable{onclick(product.id)} ) {
        Row(modifier = Modifier.fillMaxWidth().height(220.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {

            Box(modifier = Modifier.size(100.dp)) {
                Image(
                    painter = painterResource(product.image),
                    contentDescription = stringResource(product.name),
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit
                )
            }
                Text(text = stringResource(product.name))
            Spacer(modifier = Modifier.weight(1f))
            //AddProductComponent(quantity, {quantity--}, {quantity++}, onclickamount(product.id))
            Row(modifier = Modifier) {
                Icon(imageVector = Icons.Filled.KeyboardArrowDown, contentDescription = "Add", modifier = Modifier.clickable{if(quantity-- > 0) {onclicklessamount(product.id) }else quantity=0})
                Text(text = "${quantity}")
                Icon(imageVector =  Icons.Filled.KeyboardArrowUp, contentDescription = "Add", modifier = Modifier.clickable{quantity++; onclickamount(product.id)})

            }
        }
    }
}