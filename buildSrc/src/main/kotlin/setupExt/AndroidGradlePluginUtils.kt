import org.gradle.api.Project
import com.android.build.gradle.BaseExtension

private const val ANDROID_EXTENSION_NAME = "android"

@Suppress("UNCHECKED_CAST")
fun <T : BaseExtension> Project.getAndroidExtension() = extensions.findByName(
    ANDROID_EXTENSION_NAME
) as? T?

fun Project.initKotlinSrcDirectories() {
    getAndroidExtension<BaseExtension>()?.sourceSets
        ?.configureEach { java.setSrcDirs(java.srcDirs + file("src/$name/kotlin")) }
}
