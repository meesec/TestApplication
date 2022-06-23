package com.example.testapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.example.testapplication.ui.theme.TestApplicationTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }

    override fun onResume() {
        super.onResume()

        setContentView(R.layout.activity)
        findViewById<ComposeView>(R.id.activity_compose_view).setContent {
            ComposeContent()
        }
    }
}

@Composable
private fun ComposeContent() =
    TestApplicationTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize(), color = MaterialTheme.colors.background) {
            Greeting("Android\nthis is the second line\nand a third\nand a fourth")
        }
    }

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestApplicationTheme {
        Greeting("Android")
    }
}