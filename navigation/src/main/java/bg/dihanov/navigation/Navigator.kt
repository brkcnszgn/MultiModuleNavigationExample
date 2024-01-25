package bg.dihanov.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions

class Navigator {
    lateinit var navController: NavController

    // navigate on main thread or nav component crashes sometimes
    fun navigateToFlow(navigationFlow: NavigationFlow) = when (navigationFlow) {
        NavigationFlow.HomeFlow -> navController.navigate(R.id.home_flow,
            navOptions = NavOptions.Builder().apply {
            setEnterAnim(androidx.navigation.ui.R.anim.nav_default_enter_anim)
            setExitAnim(androidx.navigation.ui.R.anim.nav_default_exit_anim)
            setPopEnterAnim(androidx.navigation.ui.R.anim.nav_default_pop_enter_anim)
            setPopExitAnim(androidx.navigation.ui.R.anim.nav_default_pop_exit_anim)

        }.build(),
            args = null)
        is NavigationFlow.DashboardFlow -> navController.navigate(R.id.dashboard_flow)
    }
}