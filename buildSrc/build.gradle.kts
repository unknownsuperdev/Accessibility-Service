plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation(Dependencies.KOTLIN_GRADLE_PLUGIN)
    implementation(Dependencies.GRADLE_BUILD_TOOLS)
}

object Dependencies {
    const val GRADLE_BUILD_TOOLS = "com.android.tools.build:gradle:${Version.GRADLE_BUILD_TOOLS}"
    const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.KOTLIN}"
}

object Version {
    const val GRADLE_BUILD_TOOLS = "8.1.4"
    const val KOTLIN = "1.9.24"
}