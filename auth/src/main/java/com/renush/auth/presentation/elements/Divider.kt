package com.renush.auth.presentation.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import com.renush.auth.R

@Composable
fun OrDivider() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .height(1.dp)     // Width of the line
                .width(90.dp)
                .background(Color.Gray) // Color of the line
        )
        Spacer(Modifier.width(5.dp))
        Text(
            "OR",
            color = Color.Gray,
//            fontFamily = FontFamily(Font(R.font.inter_regular)),
            fontSize = 10.sp
        )
        Spacer(Modifier.width(5.dp))
        Box(
            modifier = Modifier
                .height(1.dp)     // Width of the line
                .width(90.dp)
                .background(Color.Gray) // Color of the line
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ODPreview() {
    OrDivider()
}