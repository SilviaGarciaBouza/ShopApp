package com.github.shopapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.material.icons.filled.*

@Composable
fun AddProductComponent(num: Int, onSum:() -> Int, onRest: ()->Int, onAddAmount:(Int)->Unit) {
    Row(modifier = Modifier) {
        Icon(imageVector = Icons.Filled.KeyboardArrowDown, contentDescription = "Add", modifier = Modifier.clickable{onSum()})
        Text(text = "$num")
        Icon(imageVector =  Icons.Filled.KeyboardArrowUp, contentDescription = "Add", modifier = Modifier.clickable{onRest()})

    }
}