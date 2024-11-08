package com.mnhyim.noteeey.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import com.mnhyim.noteeey.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val fontFamily = FontFamily(
    Font(
        googleFont = GoogleFont("Lato"),
        fontProvider = provider
    )
)

private val defaultTypography = Typography()
val Typography = Typography(
    displayLarge = defaultTypography.displayLarge.copy(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal
    ),
    displayMedium = defaultTypography.displayMedium.copy(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal
    ),
    displaySmall = defaultTypography.displaySmall.copy(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal
    ),
    headlineLarge = defaultTypography.headlineLarge.copy(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal
    ),
    headlineMedium = defaultTypography.headlineMedium.copy(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal
    ),
    headlineSmall = defaultTypography.headlineSmall.copy(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal
    ),
    titleLarge = defaultTypography.titleLarge.copy(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold
    ),
    titleMedium = defaultTypography.titleMedium.copy(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold
    ),
    titleSmall = defaultTypography.titleSmall.copy(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold
    ),
    bodyLarge = defaultTypography.bodyLarge.copy(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal
    ),
    bodyMedium = defaultTypography.bodyMedium.copy(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal
    ),
    bodySmall = defaultTypography.bodySmall.copy(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal
    ),
    labelLarge = defaultTypography.labelLarge.copy(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Thin
    ),
    labelMedium = defaultTypography.labelMedium.copy(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Thin
    ),
    labelSmall = defaultTypography.labelSmall.copy(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Thin
    ),
    /* Default text styles override
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )*/
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)