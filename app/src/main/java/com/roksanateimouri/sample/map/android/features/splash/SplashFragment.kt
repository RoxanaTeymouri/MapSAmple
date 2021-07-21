package com.roksanateimouri.sample.map.android.features.splash

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.roksanateimouri.sample.map.android.R
import com.roksanateimouri.sample.map.android.base.BaseFragment
import com.roksanateimouri.sample.map.android.utils.isNetworkAvailable
import kotlinx.android.synthetic.main.fragment_splash.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Splash fragment that decides wich page must be shown to the user based on internet connection
 *
 */
class SplashFragment : BaseFragment() {

    private val viewModel: SplashViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun tryAgainDialogAction() {
        viewModel.decideNextView(isNetworkAvailable(requireContext()))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeErrorMessage(viewModel.getExceptionData())
        task_one.setOnClickListener {
            findNavController().navigate(R.id.action_splashFragment_to_vehicleListFragment)
        }
        task_two.setOnClickListener {
            findNavController().navigate(R.id.action_splashFragment_to_mapsFragment)
        }
        Handler().postDelayed(
            { viewModel.decideNextView(isNetworkAvailable(requireContext())) },
            1500
        )
    }
}