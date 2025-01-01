package com.renush.auth.presentation.screens.tab_screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.renush.auth.R
import com.renush.auth.presentation.elements.NormalBtn
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CreatePasswordScreen(tabState : PagerState) {
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Create password screen!")
        NormalBtn(
            modifier = Modifier,
            btnText = "Continue",
            textColor = Color.White,
            backgroundColor = colorResource(
                R.color.light_blue_color
            ),
            corner = 10.dp
        ) {
            coroutineScope.launch {
                tabState.animateScrollToPage(1)
            }
        }
    }
}