package com.github.shopapp.navigation

import ProductDetailScreen
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.github.shopapp.ui.components.BuyComponent
import com.github.shopapp.ui.components.ListComponent
import com.github.shopapp.ui.components.ProductDetailComponent
import com.github.shopapp.ui.screeens.BuyScreen
import com.github.shopapp.ui.screeens.ListScreen
import com.github.shopapp.vewmodel.ProductViewModel

@Composable

fun ProductNav(prodviewModel: ProductViewModel= viewModel()) {
    val navController: NavHostController = rememberNavController()
    val viewModel by prodviewModel.listState.collectAsState()
    NavHost(
        navController = navController,
        startDestination = "list"){
        composable(route= "list") {
            ListScreen({navController.navigate("buy")},amount = viewModel.totalAmount,viewModel.listProductsState, {navController.popBackStack()}, {id ->navController.navigate("detail/$id")}, {id->prodviewModel.addChangeAmount(id)},{id->prodviewModel.lessChangeAmount(id)})
        }
        composable(route= "detail/{id}",
            arguments = listOf(navArgument(name="id") {type = NavType.IntType})
            ) {backStackEntry ->
            val id= backStackEntry.arguments?.getInt("id") ?: 0
            ProductDetailScreen({navController.navigate("buy")},amount = viewModel.totalAmount,viewModel.listProductsState[id],{navController.popBackStack()}, {product, quantity -> prodviewModel.addTocart(product,quantity)})
        }
        composable(route= "buy") {
            BuyScreen(onCero = {prodviewModel.amountCero()}, amount = viewModel.totalAmount, price = viewModel.totalAmount,{navController.popBackStack()})
        }


    }
}