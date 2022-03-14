package com.example.sampleembedding

import android.net.wifi.WifiManager
import android.os.Bundle
import android.util.Log
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
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        warmUpFlutterEngine()
        setContent {
            SampleembeddingTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column {
                        Greeting("Android")
                        startFlutterActivityButton {
                            // todo: cannot resolve FlutterActivity.
                            startActivity(
                                // FlutterActivity.createDefaultIntent(this@MainActivity)
                                FlutterActivity.withCachedEngine(ENGINE_ID).build(this@MainActivity)
                            )
                        }
                    }
                }
            }
        }
    }

    private val flutterEngine: FlutterEngine by lazy {
        FlutterEngine(this)
    }

    val ENGINE_ID = "flutter_engine"

    private var isWarmedUp = false

    fun warmUpFlutterEngine() {
        flutterEngine.dartExecutor.executeDartEntrypoint(
            DartExecutor.DartEntrypoint.createDefault()
        )

        FlutterEngineCache
            .getInstance()
            .put(ENGINE_ID, flutterEngine)
        isWarmedUp = true
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
