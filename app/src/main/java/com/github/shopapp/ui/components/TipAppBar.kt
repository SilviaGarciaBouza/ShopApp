package com.github.shopapp.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.github.shopapp.R
import com.github.shopapp.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TipAppBar(amount: Double ,modifier: Modifier= Modifier,isBackIcon:Boolean, onBackClick:()->Unit,onclickPrice:()->Unit) {
    TopAppBar(modifier = modifier.background(Color.Red),
       title = { Text(stringResource(R.string.app_name)) },
        actions = {
            Text(text="$amount")
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "",
                tint = Color.Black,
                modifier = Modifier.clickable { onclickPrice() }.padding(22.dp)
            )
        },
        navigationIcon = {
            if(isBackIcon){
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Volver",
                    )
                }
            }
        }
    )
}




//        Text(text = stringResource(R.string.app_name), color = Color.White,
//        style = Typography.titleLarge, modifier = modifier.padding(top= 28.dp, start = 28.dp, end= 28.dp)
//        )
//        Icon( imageVector= Icons.Default.ShoppingCart, contentDescription = "supermarket",modifier = modifier.padding( top= 28.dp, start = 28.dp, end= 28.dp))
//
//
