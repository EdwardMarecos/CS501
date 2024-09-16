package com.example.funfactsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.funfactsapp.ui.theme.FunFactsAppTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FunFactsAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    FunFact(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .background(Color(0xFF7393B3))
                    )
                }
            }
        }
    }
}

@Composable
fun FunFact(modifier: Modifier = Modifier) {

    val randomIndex = Random.nextInt(quotes.size)
    val currentQuote = remember { mutableStateOf(quotes[randomIndex]) }

    Column(
        modifier = modifier // Apply the modifier here
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = currentQuote.value,
            modifier = Modifier // Use a new Modifier here
                .fillMaxWidth()
                .padding(16.dp),
            textAlign = TextAlign.Center,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Button(
            modifier = Modifier
                .padding(16.dp)
                .clip(CutCornerShape(topStart = 20.dp, topEnd = 0.dp, bottomEnd = 20.dp, bottomStart = 0.dp)),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff808080),
                contentColor = contentColorFor(Color(0xff808080))
            ),
            onClick = {
                val newRandomIndex = Random.nextInt(quotes.size)
                currentQuote.value = quotes[newRandomIndex]
            }
        ) {
            Text(
                modifier = Modifier
                    .padding(8.dp),
                color = Color.White,
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                text = "Next Fact",
                fontStyle = FontStyle.Italic,
                textDecoration = TextDecoration.Underline,
//                fontFamily = FontFamily.Cursive   // did not like this one bit
            )
        }
    }
}


val quotes = listOf(
    "Sharks have been around for over 400 million years, making them older than dinosaurs and even trees. They've survived five mass extinctions.",
    "Sharks have special organs called ampullae of Lorenzini that allow them to detect electrical fields produced by the movements of other animals, helping them locate prey even in the dark.",
    "While most sharks live for 20 to 30 years, the Greenland shark can live for over 400 years, making it the longest-living vertebrate known to science.",
    "Unlike most fish, sharks don't have bones. Their skeletons are made of cartilage, the same flexible material found in human ears and noses, which makes them lighter and more agile swimmers.",
    "Sharks can have up to 35,000 teeth in their lifetime. They constantly lose and replace them, with some species having rows of backup teeth ready to move forward when one falls out.",
    "The whale shark is the largest shark and fish in the ocean, reaching lengths of up to 40 feet or more. Despite its size, it feeds mainly on plankton and is harmless to humans.",
    "As apex predators, sharks play a crucial role in maintaining the balance of marine ecosystems by controlling the population of other species and keeping the ocean food chain healthy.",
    "A shark's skin is covered in tiny tooth-like structures called dermal denticles, which reduce drag and allow them to swim more quietly and efficiently. This has inspired technology for aircraft and swimsuits.",
    "Sharks have an acute sense of smell, capable of detecting one part of blood in a million parts of water, which helps them locate prey from great distances.",
    "There are over 500 known species of sharks, ranging from the tiny dwarf lantern shark, which is about the size of a human hand, to the enormous whale shark.",
    "Certain deep-sea shark species, like the lantern shark, have bioluminescent organs that allow them to glow in the dark. This ability helps them camouflage and communicate.",
    "Hammerhead sharks have a unique head shape that allows them to have a 360-degree view, giving them an advantage in spotting prey and avoiding predators.",
    "Unlike most fish, sharks lack swim bladders. To stay afloat, they rely on their large, oily liver and dynamic lift from their fins and body shape.",
    "Shark mating rituals are still largely a mystery. However, we do know that it often involves biting, with males biting females to hold on during mating.",
    "Depending on the species, sharks can be oviparous (laying eggs), viviparous (giving live birth), or ovoviviparous (eggs hatch inside the mother and then give birth to live young).",
    "Some shark species must swim continuously to breathe, as they rely on water passing over their gills for oxygen. They can 'sleep' by resting parts of their brain while still swimming.",
    "A shark's skin feels like sandpaper due to its dermal denticles. In ancient times, it was used as sandpaper, and even today, it's sometimes used for polishing wood.",
    "Overfishing for shark fin soup has led to the decline of many shark populations worldwide. It's estimated that up to 100 million sharks are killed each year for their fins.",
    "Blue sharks are known for their long-distance migrations, traveling thousands of miles across oceans in search of food and mates.",
    "Just like humans, sharks can get sunburned if they spend too much time near the surface. Some species, like great whites, have been observed developing sunburn-like lesions."
)


@Preview(showBackground = true)
@Composable
fun FunFactPreview() {
    FunFactsAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            FunFact(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(Color(0xff4f6d82))
            )
        }
    }
}