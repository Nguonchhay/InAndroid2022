package com.nguonchhay.inandroid2022.ui.composes

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nguonchhay.inandroid2022.ui.composes.ui.theme.InAndroid2022Theme
import com.nguonchhay.inandroid2022.ui.composes.viewmodels.CalculatorComposeViewModel
import com.nguonchhay.inandroid2022.ui.composes.viewmodels.CalculatorState

class CalculatorComposeActivity : ComponentActivity() {

    val calVM by viewModels<CalculatorComposeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InAndroid2022Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CompositionLocalProvider(CalculatorState provides calVM) {
                        CalculatorContent()
                    }
                }
            }
        }
    }
}

@Composable
fun CalculatorContent() {
    val vm = CalculatorState.current
    var value1 by remember { mutableStateOf(TextFieldValue("")) }
    var value2 by remember { mutableStateOf(TextFieldValue("")) }
    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(15.dp)
    ) {
        Text(
            text = "Simple Calculator",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Green
        )

        OutlinedTextField(
            value = value1,
            label = { Text(text = "Value 1: ") },
            onValueChange = { inputValue ->
                value1 = inputValue
            }
        )

        OutlinedTextField(
            value = value2,
            label = { Text(text = "Value 2: ")},
            onValueChange = {
                value2 = it
            }
        )

        Row {
            Button(
                onClick = {
                    vm.sum(value1.text.toDouble(), value2.text.toDouble())
                }
            ) {
                Text(text = " + ")
            }

            Spacer(modifier = Modifier.padding(5.dp))

            Button(
                onClick = {
                    vm.minus(value1.text.toDouble(), value2.text.toDouble())
                }
            ) {
                Text(text = " - ")
            }

            Spacer(modifier = Modifier.padding(5.dp))

            Button(
                onClick = {
                    vm.mul(value1.text.toDouble(), value2.text.toDouble())
                }
            ) {
                Text(text = " * ")
            }
        }

        OutlinedTextField(
            value = vm.resultState.value,
            label = { Text(text = "Result: ")},
            onValueChange = {}
        )

        Button(
            onClick = {
                context.startActivity(Intent(context, NewsComposeActivity::class.java))
            }
        ) {
            Text(
                text = "Compose Bottom Navigation"
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    InAndroid2022Theme {
        CalculatorContent()
    }
}