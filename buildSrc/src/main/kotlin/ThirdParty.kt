object ThirdParty {

    object AndroidX {
        const val CORE_KTX = "androidx.core:core-ktx:${Version.CORE_KTX}"
        const val APP_COMPAT = "androidx.appcompat:appcompat:${Version.APP_COMPAT}"
        const val LEGACY_SUPPORT = "androidx.legacy:legacy-support-v4:${Version.LEGACY_SUPPORT}"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Version.CONSTRAINT_LAYOUT}"
        const val LIFECYCLE_COMMON = "androidx.lifecycle:lifecycle-common-java8:${Version.LIFECYCLE_COMMON}"
        const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Version.FRAGMENT_KTX}"
        const val NAVIGATION_FRAGMENT_KTX = "androidx.navigation:navigation-fragment-ktx:${Version.NAVIGATION_KTX}"
        const val NAVIGATION_UI_KTX = "androidx.navigation:navigation-ui-ktx:${Version.NAVIGATION_KTX}"
        const val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:${Version.RECYCLER_VIEW}"
        const val ROOM_RUNTIME = "androidx.room:room-runtime:${Version.ROOM_VERSION}"
        const val ROOM_COMPILER = "androidx.room:room-compiler:${Version.ROOM_VERSION}"
        const val ROOM_KTX = "androidx.room:room-ktx:${Version.ROOM_VERSION}"
        const val NAVIGATION_RUNTIME = "androidx.navigation:navigation-runtime-ktx:${Version.NAVIGATION_RUNTIME}"
        const val LIVECYCLE_CORE = "androidx.lifecycle:lifecycle-livedata-core:${Version.LIVECYCLE}"
        const val LIVECYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.LIVECYCLE}"
    }

    object Kotlin {
        const val STDLIB_BOM = "org.jetbrains.kotlin:kotlin-bom:${Version.KOTLIN}"
        const val STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:${Version.KOTLIN}"
        const val SERIALIZATION_JSON = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Version.KOTLINX_SERIALIZATION_JSON}"
    }

    object Libraries {

        object Di {
            const val KOIN_ANDROID = "io.insert-koin:koin-android:${Version.KOIN_ANDROID}"
            const val KOIN_ANNOTATIONS = "io.insert-koin:koin-annotations:${Version.KOIN_ANNOTATIONS}"
        }

        object Retrofit {
            const val RETROFIT = "com.squareup.retrofit2:retrofit:${Version.RETROFIT}"
            const val GSON_CONVERTER = "com.squareup.retrofit2:converter-gson:${Version.GSON_CONVERTER}"
        }

        object Okhttp {
            const val LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Version.LOGGING_INTERCEPTOR}"
            const val OKHTTP_PROFILER = "com.localebro:okhttpprofiler:${Version.OKHTTP_PROFILER}"
        }

        object Design {
            const val MATERIAL = "com.google.android.material:material:${Version.MATERIAL}"
            const val VIEW_BINDING = "com.github.kirich1409:viewbindingpropertydelegate:${Version.VIEW_BINDING}"
        }

        object LottieAnimation {
            const val LOTTIE_ANDROID = "com.airbnb.android:lottie:${Version.LOTTIE_ANDROID}"
        }

        object Coroutines {
            const val CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.COROUTINES}"
            const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.COROUTINES}"
        }

        object Time {
            const val JODATIME = "net.danlew:android.joda:${Version.JODATIME}"
        }
    }
    
    object Test {
        const val JUNIT = "junit:junit:${Version.JUNIT}"
        const val COROUTINES_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.COROUTINES_TEST}"
    }
    
    object AndroidTest {
        const val ANDROIDX_JUNIT = "androidx.test.ext:junit:${Version.ANDROIDX_JUNIT}"
        const val ANDROIDX_ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Version.ANDROIDX_ESPRESSO_CORE}"
        const val ARCH_CORE_TESTING = "androidx.arch.core:core-testing:${Version.ARCH_CORE_TESTING}"
    }
}