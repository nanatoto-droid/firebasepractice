package com.imani.firebaseimani.ui.theme.Screens.Products

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil3.compose.rememberAsyncImagePainter
import com.imani.firebaseimani.R
import com.imani.firebaseimani.data.productviewmodel
import com.imani.firebaseimani.model.Upload
import com.imani.firebaseimani.navigation.ROUTE_UPDATE_PRODUCT


@Composable
fun ViewUploadsScreen(navController:NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top) {

        var context = LocalContext.current
        var productRepository = productviewmodel(navController, context)


        val emptyUploadState = remember { mutableStateOf(Upload("","","","","")) }
        var emptyUploadsListState = remember { mutableStateListOf<Upload>() }

        var uploads = productRepository.viewUploads(emptyUploadState, emptyUploadsListState)


        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Gray),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier=Modifier.height(30.dp))
            Image(painter = painterResource(id = R.drawable.loggo3),
                contentDescription = "logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp))
            Spacer(modifier = Modifier.height(20.dp))

            Text(text = "All uploads",
                fontSize = 30.sp,
                fontFamily = FontFamily.Monospace,
                color = Color.Black,
                fontStyle = FontStyle.Italic)

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(){
                items(uploads){
                    UploadItem(
                        name = it.name,
                        quantity = it.quantity,
                        price = it.price,
                        imageUrl = it.imageUrl,
                        id = it.id,
                        navController = navController,
                        productRepository = productRepository
                    )
                }
            }
        }
    }
}

@Composable
fun Upload(x0: String, x1: String, x2: String, x3: String, x4: String) {
    TODO("Not yet implemented")
}


@Composable
fun UploadItem(name:String, quantity:String, price:String, imageUrl:String, id:String,
               navController:NavHostController, productRepository:productviewmodel) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = name)
        Text(text = quantity)
        Text(text = price)
        Image(
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = null,
            modifier = Modifier.size(128.dp)
        )
        Button(onClick = {
            productRepository.deleteProduct(id)
        }) {
            Text(text = "Delete")
        }
        Button(onClick = {
            navController.navigate(ROUTE_UPDATE_PRODUCT+"/$id")
        }) {
            Text(text = "Update")
        }
    }
}