android.namespace = ProjectsNameSpace.INSTAGRAM_ACCESSIBILITY_SERVICE

plugins {
    id(Plugin.ANDROID_LIBRARY)
    id(Plugin.KOTLIN_ANDROID)
}

dependencies {
    implementation(project(Projects.Core.CORE_API))
    implementation(project(Projects.Core.COROUTINES))
    implementation(project(Projects.Domain.DOMAIN))
}
