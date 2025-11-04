package com.github.shopapp.ui.screeens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.github.shopapp.data.CardItem
import com.github.shopapp.ui.components.TipAppBar

@Composable
fun CartScreen(listCardItems: List<CardItem>, onBackClick:() ->Unit,onb:() ->Unit, amount:Double,  ) {
   Scaffold(
       topBar ={ TipAppBar(onb={onb()},amount=amount,modifier = Modifier, false, onBackClick,{})}

   ) {
       contentPadding ->
       LazyColumn(modifier = Modifier.padding(contentPadding)) {
           items(listCardItems.size){
               index -> Card(){

           }
           }
       }
   }
}