import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.github.shopapp.data.Product
import com.github.shopapp.ui.components.ProductDetailComponent
import com.github.shopapp.ui.components.TipAppBar

@Composable
fun ProductDetailScreen(onb:()->Unit,amount: Double,product: Product, onBackClick:()->Unit){
    Scaffold(
        topBar = {TipAppBar(onb={onb()},amount= amount,modifier = Modifier, true, onBackClick,{})}
    ) {
        paddingValues ->
        ProductDetailComponent(product= product, modifier= Modifier.padding(paddingValues))
    }
}