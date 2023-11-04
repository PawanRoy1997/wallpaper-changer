# Basic Wallpaper Manager App

## Prerequisite

*Wallpaper Manager* class which provides access to the wallpaper.

With this class you can
- You can get the current wallpaper
- Get the desired dimensions for wallpaper
- Set the current wallpaper
- Set the engine for live wallpaper etc.

## Operation
We need two permissions for the basic wallpaper
```xml
<uses-permission android:name="android.permission.SET_WALLPAPER"/>
<uses-permission android:name="android.permission.SET_WALLPAPER_HINTS"/>
```

In the activity we just have to get the bitmap of the wallpaper which we want to set then we have to do the following:
```Kotlin
 val wallpaperManager = WallpaperManager.getInstance(this)
try {
    wallpaperManager.setBitmap(bitmap)
    Toast.makeText(context, "Operation Successful", Toast.LENGTH_SHORT).show()
    log.d(TAG, "Operation Successful")
} catch (e: Exception) {
    log.e(TAG, "Operation Failed with exception: ${e.message}")
}
```