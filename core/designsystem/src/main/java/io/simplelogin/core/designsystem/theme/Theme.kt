package io.simplelogin.core.designsystem.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFA0C9FF),
    onPrimary = Color(0xFF003258),
    primaryContainer = Color(0xFF004A77),
    onPrimaryContainer = Color(0xFFD1E4FF),
    secondary = Color(0xFFB8C8DC),
    onSecondary = Color(0xFF223242),
    secondaryContainer = Color(0xFF38495B),
    onSecondaryContainer = Color(0xFFD4E4F8),
    tertiary = Color(0xFFC4C7FF),
    onTertiary = Color(0xFF2D3165),
    tertiaryContainer = Color(0xFF454879),
    onTertiaryContainer = Color(0xFFE1E0FF),
    background = Color(0xFF101418),
    onBackground = Color(0xFFE0E2E8),
    surface = Color(0xFF101418),
    onSurface = Color(0xFFE0E2E8)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF0067A9),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFD1E4FF),
    onPrimaryContainer = Color(0xFF001D36),
    secondary = Color(0xFF4F6075),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFD3E4FA),
    onSecondaryContainer = Color(0xFF0B1D30),
    tertiary = Color(0xFF465D91),
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = Color(0xFFDAE2FF),
    onTertiaryContainer = Color(0xFF001A41),
    background = Color(0xFFF8F9FC),
    onBackground = Color(0xFF191C20),
    surface = Color(0xFFF8F9FC),
    onSurface = Color(0xFF191C20)
)

@Composable
fun SimpleLoginTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
