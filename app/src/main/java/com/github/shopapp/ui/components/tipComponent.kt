package com.github.shopapp.ui.components

import android.icu.text.DecimalFormat
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Icon
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import kotlin.math.ceil



@Composable
fun TipComponent(modifier: Modifier, ){
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        var billAmountS by rememberSaveable { mutableStateOf("") }
        var tipPercentageS by rememberSaveable { mutableStateOf("") }
        var boolRound by rememberSaveable { mutableStateOf(false) }
        var tipAmout by rememberSaveable { mutableStateOf(0.0) }

        var billAmount = billAmountS.toDoubleOrNull() ?: 0.0
        var tipPercentage = tipPercentageS.toDoubleOrNull() ?: 0.0
        Text(text = "Calculate tip")
        TextField(
            value = billAmountS, //contenido real
            onValueChange = {billAmountS = it},
            leadingIcon = {Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "bill amount", modifier = Modifier, tint = Color.Gray)
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            placeholder = {
                Text("Bill Amount") }// texto dentro de sugerencia
            //label = { Text("Introduce tu nombre") } encima deltextfield
        )
            //Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "bill amount", modifier = Modifier, tint = Color.Transparent)
        Spacer(modifier.width(4.dp))
        TextField(
            value = tipPercentageS,
            onValueChange = {tipPercentageS= it},
            placeholder = {
                Text(text =  "Tip percentage")
            },
            leadingIcon = {Icon(imageVector = Icons.Filled.Lock, contentDescription = "Tip percentage", modifier = Modifier, tint = Color.Gray)
            }
        )
        Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Text(text = "Round up ip?")
            Switch(checked = boolRound, onCheckedChange = {boolRound = !boolRound})

        }
        Text("Tip Amount: $ ${(roundInt(boolRound,round(billAmount,tipPercentage)))}")
    }

}

fun round(amount: Double, tip: Double ):Double{

return  amount*(tip/100.0);
}

fun roundInt(bool: Boolean,num:Double): Double{
    if(bool==true) {
        return ceil(num)
    }else{
        return num
    }
    //floor(1.1) 1.1.rountToInt()
}