package com.example.buttonsproject

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.buttonsproject.ui.theme.ButtonsProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainLayout()
        }
    }
}


@Composable
fun MainLayout() {
    Surface(
        color = Color.Cyan,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            var tapCount by remember { mutableIntStateOf(0) }
            Text(
                text = "Button Taps: $tapCount",
                fontSize = 36.sp
            )
            val context = LocalContext.current;
            Button(
                onClick = {
                    tapCount++
                }
            ) {
                Text(
                    text = "Click gng",
                    color = Color.Magenta,
                    fontSize = 24.sp

                )
            }
            Button(
                onClick = {
                    tapCount++
                    val Toast = Toast.makeText(context, "Toast!", Toast.LENGTH_SHORT)
                    Toast.show()
                }
            ) {
                Row {
                    Icon(
                        painter = painterResource(R.drawable.outline_panorama_24),
                        contentDescription = "stuff",
                    )
                    Text(
                        text = " Toast Check",
                        color = Color.Yellow,
                        fontSize = 24.sp
                    )
                }
            }

        }
    }
}


@Preview
@Composable
fun MainLayoutPreview() {
    MainLayout()
}
