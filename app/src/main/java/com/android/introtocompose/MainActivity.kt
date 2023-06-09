package com.android.introtocompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.introtocompose.MainActivity.Companion.TAG
import com.android.introtocompose.ui.theme.IntroToComposeTheme

class MainActivity : ComponentActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroToComposeTheme {
                // A surface container using the 'background' color from the theme
                MyApp()
            }
        }
    }


}


@Composable
fun MyApp() {
    // Hoisted state of counter
    val counter = remember {
        mutableStateOf(0)
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(), color = MaterialTheme.colors.primary
    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "$${counter.value}", style = TextStyle(
                    color = Color.Red, fontSize = 30.sp, fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(40.dp))
            createCircle(counter.value) { newValue ->
                counter.value = newValue
            }
        }
    }
}

//@Preview
@Composable
fun createCircle(
    counter: Int = 0,
    updateCount: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(all = 3.dp)
            .size(55.dp)
            .clickable {
                updateCount(counter + 1)
            },
        shape = CircleShape,
        elevation = 4.dp
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = "Tap")
        }
    }

}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
    /*  Column() {
          Greeting("Android")
          showAge(50)
      }*/
}


@Preview(name = "test", showBackground = true)
@Composable
fun DefaultPreview() {
    IntroToComposeTheme {
        MyApp()
    }
}