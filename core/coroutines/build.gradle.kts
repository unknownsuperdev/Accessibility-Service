android.namespace = ProjectsNameSpace.COROUTINES

plugins {
    id(Plugin.ANDROID_LIBRARY)
}

dependencies {
    implementation(ThirdParty.AndroidX.FRAGMENT_KTX)
    implementation(ThirdParty.Libraries.Coroutines.COROUTINES)
}
