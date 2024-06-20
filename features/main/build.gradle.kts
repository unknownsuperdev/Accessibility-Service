android.namespace = ProjectsNameSpace.FEATURE_MAIN

plugins {
    id(Plugin.ANDROID_LIBRARY)
}

dependencies {
    implementation(project(Projects.Core.CORE_API))
    implementation(project(Projects.Core.FRAGMENT))
    implementation(project(Projects.Core.VIEW_MODEL))
    implementation(project(Projects.Core.COROUTINES))
    implementation(project(Projects.Core.DESTINATION_PROVIDER))
    implementation(project(Projects.Core.BASE_ADAPTERS))
    implementation(project(Projects.Core.BASE_ADAPTERS))

    implementation(project(Projects.Ui.DESIGN_SYSTEM))

    implementation(project(Projects.Domain.DOMAIN))

    implementation(project(Projects.Middleware.INSTAGRAM_ACCESSIBILITY_SERVICE))

    implementation(ThirdParty.AndroidX.FRAGMENT_KTX)
    implementation(ThirdParty.AndroidX.NAVIGATION_FRAGMENT_KTX)
    implementation(ThirdParty.AndroidX.CONSTRAINT_LAYOUT)
    implementation(ThirdParty.AndroidX.CORE_KTX)
    implementation(ThirdParty.Libraries.Design.MATERIAL)

    implementation(ThirdParty.Libraries.Coroutines.COROUTINES)
    implementation(ThirdParty.Libraries.Design.VIEW_BINDING)
}
