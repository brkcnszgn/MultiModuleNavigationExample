package bg.dihanov.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import bg.dihanov.navigation.NavigationFlow
import bg.dihanov.navigation.ToFlowNavigatable


class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.to_next_fragment_btn).setOnClickListener {
            findNavController().navigate(R.id.nextFragment, navOptions = NavOptions.Builder().apply {
                setEnterAnim(androidx.navigation.ui.R.anim.nav_default_enter_anim)
                setExitAnim(androidx.navigation.ui.R.anim.nav_default_exit_anim)
                setPopEnterAnim(androidx.navigation.ui.R.anim.nav_default_pop_enter_anim)
                setPopExitAnim(androidx.navigation.ui.R.anim.nav_default_pop_exit_anim)

            }.build(), args = null)
        }

        view.findViewById<Button>(R.id.to_dashboard_flow).setOnClickListener {
            (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.DashboardFlow("From home fragment"))
        }
    }
}