android.namespace = ProjectsNameSpace.FRAGMENT

plugins {
    id(Plugin.ANDROID_LIBRARY)
}

dependencies {
    implementation(project(Projects.Core.VIEW_MODEL))
    implementation(project(Projects.Core.COROUTINES))
    implementation(project(Projects.Core.CORE_API))

    implementation(ThirdParty.AndroidX.FRAGMENT_KTX)
    implementation(ThirdParty.AndroidX.NAVIGATION_FRAGMENT_KTX)

    implementation(ThirdParty.Libraries.Design.MATERIAL)
    implementation(ThirdParty.Libraries.Coroutines.COROUTINES)
}
