object Projects {
    object Core {
        private const val CORE = ":core"
        const val CORE_API = "$CORE:api"
        const val VIEW_MODEL = "$CORE:viewModel"
        const val FRAGMENT = "$CORE:fragment"
        const val DESTINATION_PROVIDER = "$CORE:destinationProvider"
        const val BASE_ADAPTERS = "$CORE:baseAdapters"
        const val COROUTINES = "$CORE:coroutines"
    }

    object Ui {
        private const val UI = ":ui"
        const val DESIGN_SYSTEM = "$UI:design_system"
    }

    object Middleware {
        private const val MIDDLEWARE = ":middleware"
        const val INSTAGRAM_ACCESSIBILITY_SERVICE = "$MIDDLEWARE:instagramAccessibilityService"
    }

    object Features {
        private const val FEATURES = ":features"
        const val MAIN = "$FEATURES:main"
    }

    object Data {
       const val DATA = ":data"
    }

    object Domain {
        const val DOMAIN = ":domain"
    }
}

object ProjectsNameSpace {
    private const val BASE_NAME = "com.project.account"
    const val CORE_API = "$BASE_NAME.core.api"
    const val VIEW_MODEL = "$BASE_NAME.viewModel"
    const val FRAGMENT = "$BASE_NAME.fragment"
    const val DESTINATION_PROVIDER = "$BASE_NAME.destinationProvider"
    const val BASE_ADAPTERS = "$BASE_NAME.baseAdapters"
    const val COROUTINES = "$BASE_NAME.coroutines"
    const val DESIGN_SYSTEM = "$BASE_NAME.design_system"
    const val DATA = "$BASE_NAME.data"
    const val DOMAIN = "$BASE_NAME.domain"
    const val INSTAGRAM_ACCESSIBILITY_SERVICE = "$BASE_NAME.instagramAccessibilityService"
    private const val FEATURES = "features"
    const val FEATURE_MAIN = "$BASE_NAME$FEATURES.main"

}