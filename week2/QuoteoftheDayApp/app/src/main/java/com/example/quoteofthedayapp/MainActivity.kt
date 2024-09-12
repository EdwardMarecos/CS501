package com.example.quoteofthedayapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quoteofthedayapp.ui.theme.QuoteOfTheDayAppTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuoteOfTheDayAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Quote(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Quote(modifier: Modifier = Modifier) {
    // begin with a random quote
    val randomIndex = Random.nextInt(quotes.size)
    val currentQuote = remember { mutableStateOf(quotes[randomIndex]) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // display the quote
        Text(
            text = currentQuote.value,
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            textAlign = TextAlign.Center
        )

        // add button to change the quoter
        Button(onClick = {
            val newRandomIndex = Random.nextInt(quotes.size)
            currentQuote.value = quotes[newRandomIndex]
        }) {
            Text(text = "Show Another Quote")
        }
    }
}

/*
    set up the quote
    display the quote
    add a button to change the quotes
    update the displayed quote
*/

val quotes = listOf(
    "Believe you can and you're halfway there.",
    "You are stronger than you think.",
    "The only way to do great work is to love what you do.",
    "Success is not the key to happiness. Happiness is the key to success.",
    "Dream big and dare to fail.",
    "Don’t wait for opportunity. Create it.",
    "Start where you are. Use what you have. Do what you can.",
    "It always seems impossible until it’s done.",
    "Your limitation—it’s only your imagination.",
    "Push yourself, because no one else is going to do it for you.",
    "Great things never come from comfort zones.",
    "Dream it. Wish it. Do it.",
    "Success doesn’t just find you. You have to go out and get it.",
    "The harder you work for something, the greater you’ll feel when you achieve it.",
    "Don’t stop when you’re tired. Stop when you’re done.",
    "Wake up with determination. Go to bed with satisfaction.",
    "Do something today that your future self will thank you for.",
    "Little things make big days.",
    "It’s going to be hard, but hard does not mean impossible.",
    "Don’t wait for the right moment, make the moment right."
)


@Preview(showBackground = true)
@Composable
fun QuotePreview() {
    QuoteOfTheDayAppTheme {
        Quote()
    }
}