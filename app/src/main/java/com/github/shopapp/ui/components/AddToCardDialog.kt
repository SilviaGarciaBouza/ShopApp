package com.github.shopapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun AddToCardDialog(onConfirm: (Int)-> Unit, onDissmiss:()->Unit) {
    var quantity by rememberSaveable { mutableStateOf(0) }
    AlertDialog(
        onDismissRequest = {onDissmiss},
        confirmButton = {
            TextButton(onClick = {onConfirm}) {
                Text("Añadir")
            }
        },
        dismissButton = {
            TextButton(onClick = {onDissmiss}) {
                Text("Cancelar")
            }
        },
        title= {Text(text= "Inserte la cantidad")},
        text= {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
                Icon(imageVector = Icons.Filled.KeyboardArrowDown, contentDescription = "Add", modifier = Modifier.clickable{if(quantity>0)quantity--} )//enabled = 0
                Text(text = "$quantity")
                Icon(imageVector =  Icons.Filled.KeyboardArrowUp, contentDescription = "Add", modifier = Modifier.clickable{quantity++})
            }
        }

    )
}