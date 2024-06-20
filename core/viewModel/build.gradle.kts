android.namespace = ProjectsNameSpace.VIEW_MODEL

plugins {
    id(Plugin.ANDROID_LIBRARY)
}

dependencies {
    implementation(project(Projects.Core.COROUTINES))

    implementation(ThirdParty.AndroidX.FRAGMENT_KTX)
    implementation(ThirdParty.AndroidX.NAVIGATION_FRAGMENT_KTX)

    implementation(ThirdParty.Libraries.Coroutines.COROUTINES)
}
