package com.example.buttonsproject

import android.graphics.drawable.Drawable
import android.icu.number.Scale
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    var backColor by remember { mutableStateOf(Color.Cyan) }
    Surface(
        color = backColor,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            val imageList : Array<Int> = arrayOf(R.drawable.dog1, R.drawable.dog2, R.drawable.dog3)
            var displayedImage by remember { mutableIntStateOf(0) }
            var showImage by remember {mutableStateOf(true)}
            var imageOpac by remember { mutableFloatStateOf(1.0f) }
            if (showImage) {
                Image(
                contentDescription = "dog1",
                alpha = imageOpac,
                contentScale = ContentScale.Crop,
                painter = painterResource(imageList.get(displayedImage)),
                modifier = Modifier
                    .size(300.dp)
                    .clickable(
                        onClick = {
                            if (imageOpac > 0) {
                                imageOpac -= 0.2f
                            } else imageOpac = 1.0f
                        }
                    )
                )
            } else {
                Spacer(
                    modifier = Modifier.size(300.dp)
                )
            }

            val context = LocalContext.current;
            Button(
                onClick = {
                    if (displayedImage >= imageList.size - 1) {
                        displayedImage = 0
                    } else {
                        displayedImage++
                    }
                }
            ){
                Text(
                    text = "Next",
                    color = Color.Magenta,
                    fontSize = 24.sp

                )
            }
            Button(
                onClick = {
                    if (showImage) {
                        showImage = false;
                    } else showImage = true;
                }
            ) {
                Row {
                    Icon(
                        painter = painterResource(R.drawable.outline_panorama_24),
                        contentDescription = "stuff",
                    )
                    Text(
                        text = " Hide/Unhide",
                        color = Color.Yellow,
                        fontSize = 24.sp
                    )
                }
            }
            Button(
                onClick = {
                    when ( backColor ) {
                        Color.Cyan -> backColor = Color.Yellow
                        Color.Yellow -> backColor = Color.Cyan
                    }
                }
            ) {
                Text(
                    text = "Change Color",
                    fontSize = 24.sp
                )
            }
        }
    }
}


@Preview
@Composable
fun MainLayoutPreview() {
    MainLayout()
}
