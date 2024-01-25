package bg.dihanov.navigation

import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavOptions

fun buildDeepLink(destination: DeepLinkDestination) =
    NavDeepLinkRequest.Builder
        .fromUri(destination.address.toUri())
        .build()

fun NavController.deepLinkNavigateTo(
    deepLinkDestination: DeepLinkDestination,
    popUpTo: Boolean = false
) {
    val builder = NavOptions.Builder().apply {
        setEnterAnim(androidx.navigation.ui.R.anim.nav_default_enter_anim)
        setExitAnim(androidx.navigation.ui.R.anim.nav_default_exit_anim)
        setPopEnterAnim(androidx.navigation.ui.R.anim.nav_default_pop_enter_anim)
        setPopExitAnim(androidx.navigation.ui.R.anim.nav_default_pop_exit_anim)

    }

    if (popUpTo) {
        builder.setPopUpTo(graph.startDestinationId, true)
    }

    navigate(
        buildDeepLink(deepLinkDestination),
        builder.build()
    )
}

sealed class DeepLinkDestination(val address: String) {
    class Dashboard(msg: String) : DeepLinkDestination("example://dashboard/exampleArgs?msg=${msg}")
    object Next : DeepLinkDestination("example://next")
}
