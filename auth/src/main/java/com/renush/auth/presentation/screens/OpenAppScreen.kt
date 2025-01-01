package com.renush.auth.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.renush.auth.R
import com.renush.auth.presentation.elements.NormalBtn
import com.renush.auth.presentation.elements.OrDivider
import com.renush.auth.presentation.elements.OutlinedBtn
import com.renush.auth.presentation.nav_graph.Routes

@Composable
fun OpenAppScreen(navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(bottom = 10.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(R.drawable.renu_foundation_logo),
            contentDescription = "",
            tint = Color.Unspecified,
            modifier = Modifier
                .size(300.dp)
                .padding(top = 40.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 35.dp)
                .padding(bottom = 30.dp)
        ) {
            NormalBtn(
                modifier = Modifier,
                btnText = "Sign in",
                textColor = Color.White,
                backgroundColor = colorResource(R.color.sign_in_btn_color_open_app),
                corner = 10.dp
            ) {
                navHostController.navigate(Routes.LoginScreen.route)
            }
            Spacer(Modifier.height(20.dp))
            OrDivider()
            Spacer(Modifier.height(20.dp))
            OutlinedBtn(
                modifier = Modifier,
                btnText = "Register",
                textColor = Color.White,
                backgroundColor = Color.Transparent,
                outlineColor = Color.White,
                outlineWidth = 2.dp,
                corner = 10.dp,
            ) {
                navHostController.navigate(Routes.SignupScreen.route)
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun OpenAppScreenPrev() {
//    OpenAppScreen()
//}