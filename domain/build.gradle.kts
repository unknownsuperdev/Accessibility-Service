android.namespace = ProjectsNameSpace.DOMAIN

plugins {
    id(Plugin.ANDROID_LIBRARY)
}

dependencies {
    implementation(project(Projects.Core.CORE_API))

    implementation(ThirdParty.AndroidX.ROOM_RUNTIME)

    implementation(ThirdParty.Kotlin.SERIALIZATION_JSON)
}
