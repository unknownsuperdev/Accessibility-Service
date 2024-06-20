rootProject.name = "Account"
include(":app")

include(
    ":core:api",
    ":core:viewModel",
    ":core:fragment",
    ":core:destinationProvider",
    ":core:baseAdapters",
    ":core:coroutines",
)

include(
    ":ui:design_system"
)

include(
    ":middleware:instagramAccessibilityService",
)

include(
    ":features:main"
)

include(
    ":data"
)

include(
    ":domain"
)