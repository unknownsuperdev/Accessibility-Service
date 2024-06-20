android.namespace = ProjectsNameSpace.DESIGN_SYSTEM

plugins {
    id(Plugin.ANDROID_LIBRARY)
}

dependencies {
    implementation(project(Projects.Core.CORE_API))

    implementation(ThirdParty.Libraries.Design.MATERIAL)
    implementation(ThirdParty.Libraries.LottieAnimation.LOTTIE_ANDROID)
}
