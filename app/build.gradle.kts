plugins {
    id(Plugin.ANDROID_APPLICATION)
    id(Plugin.KOTLIN_ANDROID)
    id(Plugin.ANDROID_NAVIGATION_SAFEARGS)
}

android {
    namespace = Android.APPLICATION_ID
    compileSdk = Android.COMPILE_SDK_VERSION
    buildToolsVersion = Android.BUILD_TOOLS_VERSION

    defaultConfig {
        versionCode = Android.VERSION_CODE
        versionName = Android.VERSION_NAME
        signingConfig = signingConfigs.getByName(BuildConfig.DEBUG.configName)
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }

        debug {
            isMinifyEnabled = false
            isDebuggable = true
            isShrinkResources = false
        }
    }
}

dependencies {
    testImplementation(ThirdParty.Test.JUNIT)
    testImplementation(ThirdParty.Test.COROUTINES_TEST)
    testImplementation(ThirdParty.Test.COROUTINES_TEST)
    testImplementation(ThirdParty.AndroidTest.ARCH_CORE_TESTING)
    androidTestImplementation(ThirdParty.AndroidTest.ANDROIDX_JUNIT)
    androidTestImplementation(ThirdParty.AndroidTest.ANDROIDX_ESPRESSO_CORE)

    implementation(ThirdParty.AndroidX.APP_COMPAT)
    implementation(ThirdParty.AndroidX.LEGACY_SUPPORT)
    implementation(ThirdParty.AndroidX.NAVIGATION_RUNTIME)
    implementation(ThirdParty.AndroidX.CORE_KTX)
    implementation(ThirdParty.AndroidX.LEGACY_SUPPORT)
    implementation(ThirdParty.AndroidX.LIVECYCLE_CORE)
    implementation(ThirdParty.AndroidX.LIVECYCLE_RUNTIME)
    implementation(ThirdParty.AndroidX.NAVIGATION_FRAGMENT_KTX)
    implementation(ThirdParty.AndroidX.NAVIGATION_UI_KTX)
    implementation(ThirdParty.AndroidX.LIFECYCLE_COMMON)
    implementation(ThirdParty.AndroidX.CONSTRAINT_LAYOUT)
    implementation(ThirdParty.AndroidX.ROOM_KTX)
    implementation(ThirdParty.AndroidX.ROOM_RUNTIME)
    implementation(ThirdParty.Libraries.Design.MATERIAL)
    implementation(ThirdParty.Libraries.Design.VIEW_BINDING)
    implementation(ThirdParty.Libraries.Okhttp.OKHTTP_PROFILER)
    implementation(ThirdParty.Libraries.Okhttp.LOGGING_INTERCEPTOR)
    implementation(ThirdParty.Libraries.Retrofit.GSON_CONVERTER)
    implementation(ThirdParty.Libraries.Retrofit.RETROFIT)
    implementation(ThirdParty.Libraries.Time.JODATIME)
    implementation(ThirdParty.Libraries.Di.KOIN_ANNOTATIONS)

    implementation(project(Projects.Core.VIEW_MODEL))
    implementation(project(Projects.Core.CORE_API))
    implementation(project(Projects.Core.COROUTINES))
    implementation(project(Projects.Core.DESTINATION_PROVIDER))

    implementation(project(Projects.Middleware.INSTAGRAM_ACCESSIBILITY_SERVICE))
    implementation(project(Projects.Domain.DOMAIN))
    implementation(project(Projects.Data.DATA))

    implementation(project(Projects.Features.MAIN))

    implementation(project(Projects.Ui.DESIGN_SYSTEM))
}