android.namespace = ProjectsNameSpace.DATA

plugins {
    id(Plugin.ANDROID_LIBRARY)
    id(Plugin.KAPT)
}

dependencies {
    implementation(project(Projects.Core.CORE_API))
    implementation(project(Projects.Core.COROUTINES))

    implementation(project(Projects.Domain.DOMAIN))

    implementation(ThirdParty.AndroidX.ROOM_KTX)
    implementation(ThirdParty.AndroidX.ROOM_RUNTIME)

    implementation(ThirdParty.Kotlin.SERIALIZATION_JSON)

    kapt(ThirdParty.AndroidX.ROOM_COMPILER)
}
