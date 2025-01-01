package com.renush.auth.presentation.screens.tab_screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import com.renush.auth.R
import com.renush.auth.presentation.elements.LightText
import com.renush.auth.presentation.elements.NormalBtn

@Composable
fun InternshipDetailsScreen() {
    val domainList = listOf(
        "UI/UX Design",
        "Software Testing",
        "Web Development",
        "Android Development",
        "Content Creator",
        "Blogging",
        "Photography",
        "Video Editing",
        "Modeling",
        "Game Development",
        "Marketing",
        "Banking",
        "Other"
    )

    val durationList = listOf(
        "1 month",
        "2 months",
        "3 months",
        "4 months",
        "5 months",
        "6 months"
    )

    var selectedDomain by remember { mutableStateOf("") } // Track selected domain
    var selectedDuration by remember { mutableStateOf("") } // Track selected duration

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Scrollable Content
        Column(
            modifier = Modifier
                .weight(1f) // Allow the column to take up remaining space
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(10.dp))
            LightText(
                btnText = "Select Internship Field",
                textSize = 16.sp,
                textColor = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 700.dp)
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(10.dp),
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    itemsIndexed(
                        items = domainList,
                        span = { index, _ ->
                            if (index == domainList.lastIndex) GridItemSpan(2) else GridItemSpan(1)
                        }
                    ) { _, item ->
                        SelectInternshipItemLy(item,
                            isSelected = selectedDomain == item,
                            onclick = { selectedDomain = item }
                        )
                    }
                }
            }
            Spacer(Modifier.height(40.dp))
            LightText(
                btnText = "Select Internship Duration",
                textSize = 18.sp,
                textColor = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(20.dp))
            durationList.forEach { item ->
                SelectInternshipItemLy(
                    item,
                    isSelected = selectedDuration == item,
                    onclick = { selectedDuration = item },
                )
                Spacer(Modifier.height(20.dp))
            }
        }

        // Fixed Button at Bottom
        NormalBtn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            btnText = "Continue",
            textColor = Color.White,
            backgroundColor = colorResource(R.color.light_blue_color),
            corner = 10.dp
        ) {
            // Button Click Logic
        }
    }
}

@Composable
@Preview(showBackground = true)
fun InternshipPreview() {
    InternshipDetailsScreen()
}

@Composable
fun SelectInternshipItemLy(text: String, isSelected: Boolean, onclick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onclick()
            }
            .height(80.dp)
            .border(
                1.dp,
                color = if (isSelected) colorResource(R.color.light_blue_color)
                else colorResource(R.color.select_internship_item_stroke),
//                color = Color.Black,
                shape = RoundedCornerShape(6.dp)
            )
            .padding(horizontal = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        LightText(btnText = text, textSize = 14.sp, textColor = Color.Black)
    }
}