package com.renush.auth.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.renush.auth.R
import com.renush.auth.presentation.elements.BlackTextInputField
import com.renush.auth.presentation.elements.BoldText
import com.renush.auth.presentation.elements.LightText
import com.renush.auth.presentation.elements.NormalBtn
import com.renush.auth.presentation.elements.OrDivider
import com.renush.auth.presentation.elements.StartIconBtn
import com.renush.auth.presentation.elements.ToggleBlackTextInputField
import com.renush.auth.presentation.nav_graph.Routes

@Composable
fun SignInScreen(navHostController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 25.dp, vertical = 25.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.back_btn),
//                imageVector = Icons.Default.ArrowBack,
                contentDescription = "",
                modifier = Modifier
                    .clickable {
                        navHostController.navigateUp()
                    }
                    .size(25.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                BoldText(btnText = "Sign In", textSize = 22.sp, textColor = Color.Black)
            }
        }
        Spacer(Modifier.height(30.dp))
        Column(
            modifier = Modifier
        ) {
            BlackTextInputField(modifier = Modifier, "Email", "john1213@gmail.com") {
                email = it
            }
            Spacer(Modifier.height(20.dp))
            ToggleBlackTextInputField(modifier = Modifier, placeHolder = "Password", hint = "Enter password") {
                password = it
            }
            Spacer(Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                LightText(
                    btnText = "Forget Password",
                    textSize = 14.sp,
                    textColor = colorResource(R.color.light_grey)
                )
            }
            Spacer(Modifier.height(20.dp))
            NormalBtn(
                modifier = Modifier,
                btnText = "Sign in",
                textColor = Color.White,
                backgroundColor = colorResource(R.color.light_blue_color),
                corner = 10.dp
            ) {

            }
            Spacer(Modifier.height(10.dp))
            OrDivider()
            Spacer(Modifier.height(10.dp))
            StartIconBtn(
                modifier = Modifier,
                icon = painterResource(R.drawable.googlr_logo),
                btnText = "Continue with Google",
                textColor = Color.Black,
                backgroundColor = Color.White,
                outlineColor = Color.Black,
                outlineWidth = 1.dp,
                corner = 10.dp
            ) { }
            Spacer(Modifier.height(30.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                LightText(
                    btnText = "Don't have an account?",
                    textSize = 14.sp,
                    textColor = colorResource(R.color.light_grey)
                )
                Spacer(Modifier.width(10.dp))
                LightText(
                    btnText = "Register",
                    textSize = 14.sp,
                    textColor = colorResource(R.color.light_grey),
                    modifier = Modifier.clickable {
                        navHostController.navigate(Routes.SignupScreen.route)
                    }
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun SignInScreenPreview() {
//    SignInScreen()
//}