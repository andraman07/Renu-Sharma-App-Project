package com.renush.auth.presentation.screens.tab_screens

import android.app.DatePickerDialog
import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.renush.auth.R
import com.renush.auth.presentation.elements.AppDropDownMenu
import com.renush.auth.presentation.elements.BlackTextInputField
import com.renush.auth.presentation.elements.EndIconField
import com.renush.auth.presentation.elements.ExpandableInputField
import com.renush.auth.presentation.elements.NormalBtn
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfileDetailsScreen(tabState: PagerState) {

    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    var fullName by remember { mutableStateOf("") }
    var dateOfBirth by remember { mutableStateOf("") }
    var qualification by remember { mutableStateOf("Select") }
    var course by remember { mutableStateOf("Select") }
    var completionYear by remember { mutableStateOf("") }
    var clgUniversity by remember { mutableStateOf("Select") }
    var address by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 10.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(Modifier.height(20.dp))
            BlackTextInputField(modifier = Modifier, "Full Name", "John Doe") {
                fullName = it
            }
            Spacer(Modifier.height(20.dp))
            EndIconField(
                modifier = Modifier, placeHolder = "Date of Birth", hint = "dd/mm/yyyy", dateOfBirth
            ) {
                // on icon click
                showDatePicker(context) {
                    dateOfBirth = it
                }
            }
            Spacer(Modifier.height(20.dp))
            AppDropDownMenu("Qualification", listOf("10th", "12th", "PG", "UG"), qualification) {
                qualification = it
            }
            Spacer(Modifier.height(20.dp))
            AppDropDownMenu("Course Specialization", listOf("CS", "ME", "EC"), course) {
                course = it
            }
            Spacer(Modifier.height(20.dp))
            BlackTextInputField(
                modifier = Modifier,
                "Year of Completion",
                "Year of Completion",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            ) {
                completionYear = it
            }
            Spacer(Modifier.height(20.dp))
            BlackTextInputField(
                modifier = Modifier,
                "College/University",
                "College/University"
            ) {
                clgUniversity = it
            }
            Spacer(Modifier.height(20.dp))
            ExpandableInputField(
                modifier = Modifier,
                "Address",
                "Address",
            ) {
                address = it
            }
            Spacer(Modifier.height(20.dp))
        }
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
                tabState.animateScrollToPage(2)
            }
        }
    }

}

//@Composable
//@Preview(showBackground = true)
//fun ProfileDetailsPreview() {
//    ProfileDetailsScreen()
//}

fun showDatePicker(
    context: Context,
    onDateSelected: (String) -> Unit
) {
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    val datePickerDialog = DatePickerDialog(
        context,
        { _, selectedYear, selectedMonth, selectedDay ->
            // Format the selected date
            val selectedDate = Calendar.getInstance().apply {
                set(selectedYear, selectedMonth, selectedDay)
            }
            val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            onDateSelected(dateFormat.format(selectedDate.time))
        },
        year,
        month,
        day
    )
    datePickerDialog.show()
}