package uz.gita.examfinal3.presentation.screens.signin

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.examfinal3.R
import uz.gita.examfinal3.databinding.ScreenSigninBinding

@AndroidEntryPoint
class SignInScreen : Fragment(R.layout.screen_signin) {
    private val binding by viewBinding(ScreenSigninBinding::bind)
    private val viewModel:SignInViewModel by viewModels<SignInViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.openSignUpLiveData.observe(viewLifecycleOwner, openSignUpScreenObserver)
        viewModel.openHomeLiveData.observe(viewLifecycleOwner, openHomeObserver)

        binding.apply {
            buttonSignUp.setOnClickListener {
                viewModel.openSignUpScreen()
            }

            buttonNextSignin.setOnClickListener {
                val email = edittextEmail.text.toString()
                val password = edittextPassword.text.toString()
                viewModel.openHomeScreen(email, password)
            }
        }


    }

    private val openSignUpScreenObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_signIn_to_signUp)
    }

    private val openHomeObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_signInScreen_to_parentScreen)
    }
}