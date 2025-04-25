package com.imani.firebaseimani.ui.theme.Screens.Home

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import com.imani.firebaseimani.navigation.ROUTE_ADD_PRODUCT
import com.imani.firebaseimani.navigation.ROUTE_VIEW_PRODUCT
import com.imani.firebaseimani.navigation.ROUTE_VIEW_UPLOAD

import  androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()

    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.back4),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically),
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Welcome to Home",
                color = Color.White,
                fontFamily = FontFamily.Serif,
                fontSize = 32.sp,
                modifier = Modifier
                    .background(Color(0x66000000), RoundedCornerShape(8.dp))
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.loggo3),
                contentDescription = "App Logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(16.dp))
            )

            ButtonWithStyle("➕ Add Product") {
                navController.navigate(ROUTE_ADD_PRODUCT)
            }

            ButtonWithStyle("📦 View Products") {
                navController.navigate(ROUTE_VIEW_PRODUCT)
            }

            ButtonWithStyle("📤 View Uploads") {
                navController.navigate(ROUTE_VIEW_UPLOAD)
            }
        }
    }
}

@Composable
fun ButtonWithStyle(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE)),
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .shadow(8.dp, RoundedCornerShape(16.dp))
    ) {
        Text(
            text = text,
            fontSize = 20.sp,
            fontFamily = FontFamily.Monospace,
            color = Color.White
        )
    }
}

@Preview
@Composable
fun HomePreview() {
    HomeScreen(rememberNavController())
}