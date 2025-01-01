package com.renush.auth.presentation.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import com.renush.auth.R

@Composable
fun BlackTextInputField(
    modifier: Modifier,
    placeHolder: String,
    hint: String,
    singleLine: Boolean = true,
    height: Dp = 40.dp,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    onTextChange: (String) -> Unit,
) {
    var text by remember { mutableStateOf("") }

    Column(
        modifier = modifier
    ) {
        Text(
            text = placeHolder,
            style = TextStyle(
                color = Color.Black,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.inter_regular))
            )
        )
        Spacer(Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(height)
                .border(1.dp, color = colorResource(R.color.light_grey), RoundedCornerShape(12.dp))
                .background(Color.Transparent)
                .padding(horizontal = 8.dp), // Custom padding for text alignment
        ) {
            BasicTextField(
                value = text,
                onValueChange = {
                    text = it
                    onTextChange(text)
                },
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.inter_regular))
                ),
                keyboardOptions = keyboardOptions,
                singleLine = singleLine,
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.CenterStart // Align text properly
                    ) {
                        if (text.isEmpty()) {
                            Text(
                                text = hint,
                                style = TextStyle(
                                    color = Color.Gray,
                                    fontSize = 14.sp,
                                    fontFamily = FontFamily(Font(R.font.inter_regular))
                                )
                            )
                        }
                        innerTextField()
                    }
                },
                modifier = Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp)
            )
        }
    }
}

@Composable
fun ToggleBlackTextInputField(
    modifier: Modifier,
    placeHolder: String,
    hint: String,
    onTextChange: (String) -> Unit
) {
    var text by remember { mutableStateOf("") }
    var isPasswordToggle by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
    ) {
        Text(
            text = placeHolder,
            style = TextStyle(
                color = Color.Black,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.inter_regular))
            )
        )
        Spacer(Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .border(1.dp, color = colorResource(R.color.light_grey), RoundedCornerShape(12.dp))
                .background(Color.Transparent)
                .padding(start = 8.dp, end = 5.dp) // Custom padding for text alignment
        ) {
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                BasicTextField(
                    value = text,
                    onValueChange = {
                        text = it
                        onTextChange(text)
                    },
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.inter_regular))
                    ),
                    singleLine = true,
                    visualTransformation = rememberUpdatedState(
                        if (isPasswordToggle) VisualTransformation.None else PasswordVisualTransformation()
                    ).value,
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier.weight(1f),
                            contentAlignment = Alignment.CenterStart // Align text properly,
                        ) {
                            if (text.isEmpty()) {
                                Text(
                                    text = hint,
                                    style = TextStyle(
                                        color = Color.Gray,
                                        fontSize = 14.sp,
                                        fontFamily = FontFamily(Font(R.font.inter_regular))
                                    )
                                )
                            }
                            innerTextField()
                        }
                    },
                    modifier = Modifier
                        .padding(10.dp, 0.dp, 10.dp, 0.dp)
                        .weight(1f)
                )
                IconButton(onClick = {
                    isPasswordToggle = !isPasswordToggle;
//                    Log.d("CHECK", isPasswordToggle.toString())
                }) {
                    Icon(
                        painter = if (isPasswordToggle) painterResource(R.drawable.pass_toggle_on) else painterResource(
                            R.drawable.pass_toggle_off
                        ),
                        contentDescription = if (isPasswordToggle) "Hide Password" else "Show Password",
                        tint = Color.Gray
                    )
                }
            }
        }
    }
}

@Composable
fun EndIconField(
    modifier: Modifier,
    placeHolder: String,
    hint: String,
    selectedDate: String = "",
    onclick: () -> Unit
) {
    var text by remember { mutableStateOf("") }

    Column(
        modifier = modifier
    ) {
        Text(
            text = placeHolder,
            style = TextStyle(
                color = Color.Black,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.inter_regular))
            )
        )
        Spacer(Modifier.height(10.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp) // Increased height for better interaction
                .border(1.dp, color = colorResource(R.color.light_grey), RoundedCornerShape(12.dp))
                .background(Color.Transparent)
                .padding(start = 8.dp, end = 0.dp) // Adjusted padding for consistency
        ) {
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                BasicTextField(
                    value = selectedDate,
                    onValueChange = { text = selectedDate },
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.inter_regular))
                    ),
                    singleLine = true,
                    readOnly = true, // Allow text input
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier.weight(1f),
                            contentAlignment = Alignment.CenterStart // Align text properly
                        ) {
                            if (selectedDate.isEmpty()) {
                                Text(
                                    text = hint,
                                    style = TextStyle(
                                        color = Color.Gray,
                                        fontSize = 14.sp,
                                        fontFamily = FontFamily(Font(R.font.inter_regular))
                                    )
                                )
                            }
                            innerTextField()
                        }
                    },
                    modifier = Modifier
                        .padding(horizontal = 10.dp) // Padding for proper text alignment
                        .weight(1f)
                )

                IconButton(onClick = {
                    onclick()
                }) {
                    Icon(
                        painter = painterResource(R.drawable.calender_vector),
//                        imageVector = Icons.Default.Place,
                        contentDescription = "",
                        tint = colorResource(R.color.light_grey),
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun ExpandableInputField(
    modifier: Modifier = Modifier,
    placeHolder: String,
    hint: String,
    minHeight: Dp = 40.dp,
    maxLines: Int = 5,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    onTextChange: (String) -> Unit
) {
    var text by remember { mutableStateOf("") }

    Column(
        modifier = modifier
    ) {
        // PlaceHolder Text
        Text(
            text = placeHolder,
            style = TextStyle(
                color = Color.Black,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.inter_regular))
            )
        )
        Spacer(modifier = Modifier.height(10.dp))

        // Text Input Box
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, color = colorResource(R.color.light_grey), RoundedCornerShape(12.dp))
                .padding(horizontal = 8.dp),
            contentAlignment = Alignment.TopStart
        ) {
            BasicTextField(
                value = text,
                onValueChange = {
                    text = it
                    onTextChange(it)
                },
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.inter_regular))
                ),
                maxLines = maxLines,
                keyboardOptions = keyboardOptions,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .heightIn(min = minHeight, max = minHeight * maxLines)
            )

            // Hint
            if (text.isEmpty()) {
                Text(
                    text = hint,
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.inter_regular))
                    ),
                    modifier = Modifier.padding(start = 8.dp, top = 10.dp)
                )
            }
        }
    }
}

