buildscript {
    repositories {
        maven(Plugin.Repositories.JIT_PUCK_URL)
        mavenCentral()
        google()
    }
    dependencies {
        classpath(ClassPaths.GOOGLE_SERVICE)
        classpath(ClassPaths.GRADLE_BUILD_TOOLS)
        classpath(ClassPaths.KOTLIN_GRADLE_PLUGIN)
        classpath(ClassPaths.SAFE_ARGS)
    }
}

allprojects {
    repositories.setupRepositories()
    with(project.plugins) {
        withId(Plugin.ANDROID_APP) { this@allprojects.setupAndroid() }

        withId(Plugin.ANDROID_LIBRARY) { this@allprojects.setupAndroid() }

        withId(Plugin.KOTLIN) { this@allprojects.setupKotlin() }

        withId(Plugin.KOTLIN_ANDROID) {
            this@allprojects.setupKotlin()
            this@allprojects.initKotlinSrcDirectories()
        }
    }
}