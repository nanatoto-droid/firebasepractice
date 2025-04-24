package com.imani.firebaseimani.ui.theme.Screens.Home

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import com.imani.firebaseimani.navigation.ROUTE_ADD_PRODUCT
import com.imani.firebaseimani.navigation.ROUTE_VIEW_PRODUCT
import com.imani.firebaseimani.navigation.ROUTE_VIEW_UPLOAD

import  androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height

import androidx.compose.material3.Button
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imani.firebaseimani.R
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Composable
fun HomeScreen(navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)
        .paint(painterResource(id=R.drawable.back5)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        var context= LocalContext.current
//        var productdata=productviewmodel(navController,context)

        Text(text = "Welcome to Home page",
            color = Color.White,
            fontFamily = FontFamily.Serif,
            fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
            fontSize = 30.sp)
        Spacer(modifier = Modifier.height(10.dp))

        Spacer(modifier=Modifier.height(30.dp))
        Image(painter = painterResource(id = R.drawable.loggo3),
            contentDescription = "logo",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp))
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate(ROUTE_ADD_PRODUCT)
        },modifier = Modifier.fillMaxWidth()) {
            Text(text = "Add Product",
                fontSize = 30.sp,
                fontFamily = FontFamily.Monospace,
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
            )
        }
        Spacer(modifier = Modifier.height(100.dp))

        Button(onClick = {
            navController.navigate(ROUTE_VIEW_PRODUCT)
        },modifier = Modifier.fillMaxWidth()) {
            Text(text = "View Product",
                fontSize = 30.sp,
                fontFamily = FontFamily.Monospace,
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic  )
        }
        Spacer(modifier = Modifier.height(100.dp))

        Button(onClick = {
            navController.navigate(ROUTE_VIEW_UPLOAD)
        },modifier = Modifier.fillMaxWidth()) {
            Text(text = "View Products",
                fontSize = 30.sp,
                fontFamily = FontFamily.Monospace,
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic  )
        }


    }



}

@Preview
@Composable
fun Homepreview() {
    HomeScreen(rememberNavController())
}