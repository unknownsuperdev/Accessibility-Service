import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.maven
import org.jetbrains.kotlin.gradle.dsl.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

private const val IMPLEMENTATION = "implementation"

fun RepositoryHandler.setupRepositories() {
    mavenCentral()
    google()
    maven(Plugin.Repositories.MAVEN_GOOGLE_URL)
    maven(Plugin.Repositories.JIT_PUCK_URL)
    maven(Plugin.Repositories.PLUGIN_GRADLE_URL)
}

fun Project.setupAndroid() {
    val androidExtension = getAndroidExtension<BaseExtension>() ?: return

    project.project.plugins.apply { apply(Plugin.KOTLIN_ANDROID) }

    with(androidExtension) {
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }

        compileSdkVersion(Android.COMPILE_SDK_VERSION)

        with(defaultConfig) {
            minSdk = Android.MIN_SDK_VERSION
            targetSdk = Android.TARGET_SDK_VERSION
        }

        buildFeatures.viewBinding = true
        buildFeatures.buildConfig = true

        packagingOptions {
            with(resources.excludes) {
                add("META-INF/*.kotlin_module")
                add("META-INF/AL2.0")
                add("META-INF/LGPL2.1")
            }
        }
    }

    dependencies {
        IMPLEMENTATION(ThirdParty.Libraries.Di.KOIN_ANDROID)
    }
}

fun Project.setupKotlin() {
    dependencies {
        IMPLEMENTATION(platform(ThirdParty.Kotlin.STDLIB_BOM))
        IMPLEMENTATION(ThirdParty.Kotlin.STDLIB)
    }
    @Suppress("UNCHECKED_CAST")
    tasks.withType(KotlinCompile::class.java) {
        (this as? KotlinCompile<KotlinJvmOptions>)?.run {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_1_8.toString()

                freeCompilerArgs += listOf(
                    "-Xinline-classes",
                    "-progressive"
                )
            }
        }
    }
}
