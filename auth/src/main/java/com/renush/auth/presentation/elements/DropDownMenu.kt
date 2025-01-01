package com.renush.auth.presentation.elements

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import com.renush.auth.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDropDownMenu(
    menuName: String, menuList: List<String>, text: String, onDropDownClick: (String) -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        androidx.compose.material.Text(
            text = menuName, style = TextStyle(
                color = Color.Black,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.inter_regular))
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        ExposedDropdownMenuBox(expanded = isExpanded,
            onExpandedChange = { isExpanded = !isExpanded }) {
            OutlinedTextField(
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
                    .height(48.dp),
                value = text,
                textStyle = TextStyle(
                    fontSize = 13.sp,
                    fontFamily = FontFamily(Font(R.font.inter_regular)),
                    color = Color.Black
                ),
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedTextColor = colorResource(R.color.light_grey),
                    unfocusedTextColor = colorResource(R.color.light_grey),
                    unfocusedTrailingIconColor = colorResource(R.color.light_grey),
                    focusedTrailingIconColor = colorResource(R.color.light_grey),
                    focusedBorderColor = colorResource(R.color.light_grey),
                    unfocusedBorderColor = colorResource(R.color.light_grey),
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(12.dp)
            )

            DropdownMenu(modifier = Modifier.background(Color.White),
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false }) {
                menuList.forEachIndexed { index, text ->
                    DropdownMenuItem(text = {
                        androidx.compose.material.Text(
                            text = text, style = TextStyle(
                                color = Color.Black,
                                fontSize = 13.sp,
                                fontFamily = FontFamily(Font(R.font.inter_regular))
                            )
                        )
                    }, onClick = {
                        onDropDownClick(menuList[index])
                        isExpanded = false
                    }, contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Prev() {
    AppDropDownMenu("test", listOf("one", "two"), "test text") { }
}