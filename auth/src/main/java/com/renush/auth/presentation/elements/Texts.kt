package com.renush.auth.presentation.elements

import androidx.compose.foundation.layout.fillMaxWidth
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import com.renush.auth.R

@Composable
fun BoldText(btnText: String, textSize: TextUnit, textColor: Color) {
    Text(
        btnText,
        style = TextStyle(fontFamily = FontFamily(Font(R.font.arial_bold_2))),
        fontSize = textSize,
        color = textColor
    )
}

@Composable
fun LightText(btnText: String, textSize: TextUnit, textColor: Color,textAlign: TextAlign = TextAlign.Center,fontWeight: FontWeight = FontWeight.Normal,modifier: Modifier = Modifier) {
    Text(
        btnText,
        style = TextStyle(fontFamily = FontFamily(Font(R.font.inter_regular))),
        fontSize = textSize,
        color = textColor,
        textAlign = textAlign,
        fontWeight = fontWeight,
        modifier = modifier
    )
}