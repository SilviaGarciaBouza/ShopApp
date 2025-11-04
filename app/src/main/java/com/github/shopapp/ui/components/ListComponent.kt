package com.github.shopapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.shopapp.data.Product

@Composable
fun ListComponent(listProduct: List<Product>, modifier: Modifier, onclick: (Int)->Unit,onclickamount: (Int)->Unit){
    LazyColumn(modifier = modifier.fillMaxSize().padding(4.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
        items(listProduct.size){
            index ->
            ItemCardComponent(listProduct[index],{onclick(index)} , {index -> onclickamount(index)})
        }
    }
}