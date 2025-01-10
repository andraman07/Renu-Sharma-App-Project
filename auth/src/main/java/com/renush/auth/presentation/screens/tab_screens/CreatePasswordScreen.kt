package com.renush.auth.presentation.screens.tab_screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.renush.auth.R
import com.renush.auth.presentation.elements.BlackTextInputField
import com.renush.auth.presentation.elements.NormalBtn
import com.renush.auth.presentation.elements.OrDivider
import com.renush.auth.presentation.elements.StartIconBtn
import com.renush.auth.presentation.elements.ToggleBlackTextInputField
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CreatePasswordScreen(tabState : PagerState) {
    val coroutineScope = rememberCoroutineScope()
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPass by remember { mutableStateOf("") }
    var contactNo by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(Modifier.height(20.dp))
        BlackTextInputField(modifier = Modifier, "Email", "john1213@gmail.com") {
            email = it
        }
        Spacer(Modifier.height(20.dp))
        BlackTextInputField(
            modifier = Modifier,
            "Year of Completion",
            "Year of Completion",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        ) {
            contactNo = it
        }
        Spacer(Modifier.height(20.dp))
        ToggleBlackTextInputField(
            modifier = Modifier,
            placeHolder = "Password",
            hint = "Enter password"
        ) {
            password = it
        }
        Spacer(Modifier.height(20.dp))
        ToggleBlackTextInputField(
            modifier = Modifier,
            placeHolder = "Re-type password",
            hint = "Re-type password"
        ) {
            confirmPass = it
        }
        Spacer(Modifier.height(50.dp))
        NormalBtn(
            modifier = Modifier,
            btnText = "Register",
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
    }
}

//@Preview(showBackground = true)
//@Composable
//fun CreatePassPRev() {
//    CreatePasswordScreen()
//}