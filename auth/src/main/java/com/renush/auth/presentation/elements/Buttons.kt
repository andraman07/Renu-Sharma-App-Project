package com.renush.auth.presentation.elements

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp

@Composable
fun NormalBtn(
    modifier: Modifier,
    btnText: String,
    textColor: Color,
    backgroundColor: Color,
    corner: Dp,
    onclick: () -> Unit
) {
    Button(
        onClick = { onclick() },
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner),
        colors = ButtonDefaults.buttonColors(
            disabledContentColor = Color.Gray,
            backgroundColor = backgroundColor
        )
    ) {
        BoldText(btnText = btnText, textSize = 16.sp, textColor = textColor)
    }
}

@Composable
fun OutlinedBtn(
    modifier: Modifier,
    btnText: String,
    textColor: Color,
    backgroundColor: Color,
    outlineColor: Color,
    outlineWidth: Dp,
    corner: Dp,
    onclick: () -> Unit
) {
    Button(
        onClick = { onclick() },
        modifier = modifier
            .fillMaxWidth()
            .border(
                border = BorderStroke(outlineWidth, outlineColor),
                shape = RoundedCornerShape(corner)
            ),
        colors = ButtonDefaults.buttonColors(
            disabledContentColor = Color.Gray,
            backgroundColor = backgroundColor
        )
    ) {
        BoldText(btnText = btnText, textSize = 16.sp, textColor = textColor)
    }
}

@Composable
fun StartIconBtn(
    modifier: Modifier = Modifier,
    icon: Painter,
    btnText: String,
    textColor: Color,
    backgroundColor: Color,
    outlineColor: Color,
    outlineWidth: Dp = 1.dp,
    corner: Dp = 8.dp,
    iconTint: Color = Color.Unspecified, // Optional tint for Icon
    onclick: () -> Unit
) {
    Button(
        onClick = { onclick() },
        modifier = modifier
            .fillMaxWidth()
            .border(
                border = BorderStroke(outlineWidth, outlineColor),
                shape = RoundedCornerShape(corner)
            ),
        shape = RoundedCornerShape(corner), // Ensures the button has rounded corners
        elevation = ButtonDefaults.elevation(0.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor, // Use backgroundColor for Material 2
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = icon,
                contentDescription = null, // Replace empty string with null
                tint = iconTint,
                modifier = Modifier.size(18.dp)
            )
            Spacer(Modifier.width(10.dp))
            BoldText(btnText = btnText, textSize = 16.sp, textColor = textColor)
        }
    }
}