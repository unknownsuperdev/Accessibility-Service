package com.project.account.instagramAccessibilityService

import android.accessibilityservice.AccessibilityService
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.ComponentActivity

internal const val MARKET_HTTPS_URI = "https://play.google.com/store/apps/details?id="
internal const val INSTAGRAM_HTTPS_URI = "https://instagram.com/"
internal const val INSTAGRAM_PACKAGE_NAME = "com.instagram.android"

private fun ComponentActivity.redirectToAccessibilitySettings() {
    try {
        val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        Toast.makeText(baseContext, "ACCESSIBILITY SETTINGS not found.", Toast.LENGTH_SHORT).show()
    }

}

fun ComponentActivity.redirectToInstagramApplication() =
    try {
        (packageManager.getLaunchIntentForPackage(INSTAGRAM_PACKAGE_NAME) ?: Intent(
            Intent.ACTION_VIEW,
            Uri.parse(INSTAGRAM_HTTPS_URI)
        )).apply {
            setAction(Intent.ACTION_VIEW)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(this@apply)
        }
    } catch (e: ActivityNotFoundException) {
        startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse(MARKET_HTTPS_URI + INSTAGRAM_PACKAGE_NAME)
            )
        )
    }


fun ComponentActivity.isAccessibilityServiceEnabled(service: Class<out AccessibilityService>): Boolean {
    val accessibilityEnabled = Settings.Secure.getInt(
        contentResolver,
        Settings.Secure.ACCESSIBILITY_ENABLED, 0
    )
    if (accessibilityEnabled == 1) {
        val enabledServicesSetting = Settings.Secure.getString(
            contentResolver,
            Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES
        )
        val colonSplitter = TextUtils.SimpleStringSplitter(':')
        colonSplitter.setString(enabledServicesSetting)
        while (colonSplitter.hasNext()) {
            val componentName = colonSplitter.next()
            if (componentName.equals("${packageName}/${service.name}", ignoreCase = true)) {
                return true
            }
        }
    } else {
        redirectToAccessibilitySettings()
    }
    return false
}
