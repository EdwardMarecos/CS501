package com.example.greetingsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.greetingsapp.ui.theme.GreetingsAppTheme
import java.util.Calendar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingsAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .background(Color(0xFFd5f5e3)) // Background color
                    ) {
                        GreetingInput() // Use GreetingInput instead of Quote
                    }
                }
            }
        }
    }
}

@Composable
fun GreetingInput() {
    val name = remember { mutableStateOf("") }
    val greetingMessage = remember { mutableStateOf("") } // To store the greeting message

    Column (
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = name.value,
            onValueChange = { name.value = it },
            label = { Text("Enter your name") },
            modifier = Modifier
                .fillMaxWidth()
        )

        Button (
            onClick = {
                greetingMessage.value = getGreetingMessage(name.value)
            },
            enabled = name.value.isNotEmpty(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff1cab5a),
                contentColor = contentColorFor(Color(0xff1cab5a))
            ),
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Greet Me",
                modifier = Modifier
                    .padding(vertical = 8.dp),
                color = Color.White,
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
            )
        }

        if (greetingMessage.value.isNotEmpty()) {
            Text(
                text = greetingMessage.value,
                color = Color(0xff1cab5a),
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
            )
        }
    }
}

fun getGreetingMessage(name: String): String {
    val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    return when (hour) {
        in 5..11 -> "Good morning, $name! Wishing you a fantastic start to your day!"
        in 12..16 -> "Good afternoon, $name! Hope your day is going great!"
        in 17..21 -> "Good evening, $name! How was your day?"
        else -> "Hello, $name! Burning the midnight oil, are we? Don't forget to rest!"
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GreetingsAppTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(Color(0xFFd5f5e3)) // Background color
            ) {
                GreetingInput() // Use GreetingInput instead of Quote
            }
        }
    }
}