package com.example.sampleembedding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.sampleembedding.ui.theme.SampleembeddingTheme
// todo: cannot resolve io
// import io.flutter.embedding.android.FlutterActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleembeddingTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column {
                        Greeting("Android")
                        startFlutterActivityButton {
                            // todo: cannot resolve FlutterActivity.
//                            startActivity(
//                                FlutterActivity.createDefaultIntent(this)
//                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun startFlutterActivityButton(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("Start Flutter Activity")
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SampleembeddingTheme {
        Column {
            Greeting("Android")
            startFlutterActivityButton {

            }
        }

    }
}