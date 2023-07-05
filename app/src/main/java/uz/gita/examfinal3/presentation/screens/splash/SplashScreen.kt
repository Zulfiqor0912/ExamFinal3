package uz.gita.examfinal3.presentation.screens.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.examfinal3.R

@AndroidEntryPoint
class SplashScreen : Fragment(R.layout.screen_splash) {
    private val viewModel by viewModels<SplashViewModelIMpl>()
    private lateinit var h: Handler

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.introLiveData.observe(viewLifecycleOwner, openOnBoardingScreenLiveData)
        h = Handler(Looper.getMainLooper())
        h.postDelayed({
            viewModel.openOnBoardingScreen()
        }, 5000)
    }

    private val openOnBoardingScreenLiveData = Observer<Unit> {
        findNavController().navigate(R.id.action_splashScreen_to_introScreen)
    }
}