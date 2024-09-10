package com.example.button

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.button.ui.theme.ButtonTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ButtonTheme {
                Surface( // Surface provides an easy way to apply a background
                    color = Color(0xffd0e3f5), // Set background color here
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(20.dp, 60.dp),
                            verticalArrangement = Arrangement.spacedBy(25.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            MyButton()
                        }
                    }
                }
            }
        }
    }


@Composable
fun MyButton() {
    var buttonText by remember { mutableStateOf("click me :3")}
    Button(
        onClick = {
            buttonText = "Hello World!"
        },
        modifier = Modifier
            .height(50.dp)
            .width(160.dp),
        shape = RoundedCornerShape(topStart = 10.dp, bottomEnd = 20.dp),
        enabled = true,
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 30.dp,
            pressedElevation = 100.dp,
            focusedElevation = 60.dp,
            hoveredElevation = 10.dp,
//            disabledElevation = not going to use rn
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFF5F5DC),
            contentColor = Color(0xFFC5D8D8),
//            disabledContentColor =
//            disabledContainerColor =
        )
    ) {
        Icon(painter = painterResource(R.drawable.click), contentDescription = null)
        Text(buttonText)
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    ButtonTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp, 60.dp),
                    verticalArrangement = Arrangement.spacedBy(25.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    MyButton()
                }
            }
        }
    }




