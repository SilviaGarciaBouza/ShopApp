package com.github.shopapp.ui.components

import android.R
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.github.shopapp.data.Product
import com.github.shopapp.ui.theme.Typography
import kotlin.time.Duration

@Composable
fun ProductDetailComponent(product: Product, modifier: Modifier,onAddtoCart:(Product, Int)->Unit) {
    var showDialog by rememberSaveable { mutableStateOf(false) }
    val mContext = LocalContext.current
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
        Spacer(modifier= Modifier.height(12.dp))
        Button(onClick= {showDialog=true}) {
            Text("Añadir")
        }

        if(showDialog){
            if(product.strock == 0){
                mensageToast(mContext, "no hay stock")
                showDialog= false
            }else{
                AddToCardDialog(onDissmiss = {showDialog=false}, onConfirm = {quantity ->showDialog=false; onAddtoCart(product, quantity)})
            }
        }
    }

}

fun mensageToast(context: Context, mesage:String){
Toast.makeText(context, mesage, Toast.LENGTH_LONG).show()
}