package com.github.shopapp.ui.screeens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.github.shopapp.ui.components.TipAppBar
import com.github.shopapp.ui.components.TipComponent

@Composable
fun TipScreen(amount: Double,modifier: Modifier,onBackClick:()->Unit) {
    Scaffold(
        topBar = { TipAppBar(amount=amount,modifier= Modifier, true, onBackClick,{}) }
    ) { paddingValues ->
        TipComponent(modifier= Modifier.padding(paddingValues));


    }
}

