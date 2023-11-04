package com.nextxform.wallpaper

import android.app.WallpaperManager
import android.content.res.AssetManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nextxform.wallpaper.ui.theme.WallpaperTheme

private const val TAG = "Wallpaper"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WallpaperTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(modifier = Modifier.fillMaxSize()) { setWallpaper() }
                }
            }
        }
    }

    private fun setWallpaper() {
        val wallpaperManager = WallpaperManager.getInstance(this)
        try {
            val assets: AssetManager = this.assets
            var bitmap: Bitmap?
            assets.open("wallpaper-01.png").use { inputStream ->
                bitmap = BitmapFactory.decodeStream(inputStream)
            }
            if(bitmap != null) wallpaperManager.setBitmap(bitmap)
            Toast.makeText(this, "Operation Successful", Toast.LENGTH_SHORT).show()
            Log.d(TAG, "setWallpaper: Operation Successful")
        } catch (e: Exception) {
            Toast.makeText(this, "Operation Failed", Toast.LENGTH_SHORT).show()
            Log.d(TAG, "setWallpaper: ${e.message}")
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier, setWallpaper: () -> Unit) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { setWallpaper.invoke() }) {
            Text(text = "Set Wallpaper")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WallpaperTheme {
        MainScreen(modifier = Modifier.fillMaxSize(), {})
    }
}