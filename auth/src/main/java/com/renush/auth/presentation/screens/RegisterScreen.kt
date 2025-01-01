package com.renush.auth.presentation.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.renush.auth.R
import com.renush.auth.presentation.elements.BoldText
import com.renush.auth.presentation.elements.LightText
import com.renush.auth.presentation.screens.tab_screens.CreatePasswordScreen
import com.renush.auth.presentation.screens.tab_screens.InternshipDetailsScreen
import com.renush.auth.presentation.screens.tab_screens.ProfileDetailsScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RegisterScreen(navHostController: NavHostController) {
    val tabState = rememberPagerState {
        3
    }
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 15.dp, vertical = 25.dp)
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
                        if (tabState.currentPage != 0) {
                            if (tabState.currentPage == 1) {
                                coroutineScope.launch {
                                    tabState.scrollToPage(0)
                                }
                            } else if (tabState.currentPage == 2) {
                                coroutineScope.launch {
                                    tabState.scrollToPage(1)
                                }
                            }
                        } else {
                            navHostController.navigateUp()
                        }
                    }
                    .size(25.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                BoldText(btnText = "Register", textSize = 22.sp, textColor = Color.Black)
            }
        }
        Spacer(Modifier.height(10.dp))
        TabRow(
            selectedTabIndex = tabState.currentPage,
            backgroundColor = Color.White,
            modifier = Modifier.fillMaxWidth(), // Ensure TabRow spans full width
            divider = {},
            indicator = { tabPositions ->
                Box(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[tabState.currentPage])
                        .height(5.dp) // Custom height for the indicator
                        .fillMaxWidth()
                        .padding(horizontal = 5.dp)
                        .background(
                            color = colorResource(id = R.color.light_blue_color), // Color of the indicator
                            shape = RoundedCornerShape(50.dp) // Rounded corners
                        )
                )
            }
        ) {
            listOf(
                "Create Password",
                "Profile Details",
                "Internship Details"
            ).forEachIndexed { index, text ->
                Tab(
                    selected = tabState.currentPage == index,
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 5.dp), // Ensure each Tab takes equal width
                    text = {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth() // Ensures Box spans full width
                                .height(IntrinsicSize.Min),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            LightText(
                                btnText = text,
                                textColor = if (tabState.currentPage == index) colorResource(id = R.color.light_blue_color) else colorResource(
                                    id = R.color.light_grey
                                ),
                                textSize = 12.sp,
                                textAlign = TextAlign.Center // Center text within its space
                            )
                        }
                    },
                    selectedContentColor = colorResource(R.color.light_blue_color),
                    unselectedContentColor = colorResource(R.color.light_grey),
                    onClick = {
                        coroutineScope.launch {
                            tabState.scrollToPage(index)
                        }
                    },
                )
            }
        }
        HorizontalPager(state = tabState, userScrollEnabled = true) { page ->
            when (page) {
                0 -> {
                    CreatePasswordScreen(tabState)
                }

                1 -> {
                    ProfileDetailsScreen(tabState)
                }

                2 -> {
                    InternshipDetailsScreen()
                }
            }
        }
    }
}
//
//@Composable
//@Preview(showBackground = true)
//fun RegisterScreenPrev() {
//    RegisterScreen()
//}