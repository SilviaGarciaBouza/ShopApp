package com.github.shopapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.github.shopapp.navigation.ProductNav
import com.github.shopapp.ui.components.TipComponent
import com.github.shopapp.ui.screeens.TipScreen
import com.github.shopapp.ui.theme.ShopAppTheme
import com.github.shopapp.vewmodel.ProductViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShopAppTheme {
                ProductNav()


            }
        }
    }
}

