package uz.gita.examfinal3.presentation.screens.signup

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.examfinal3.R
import uz.gita.examfinal3.databinding.ScreenSignupBinding
import uz.gita.examfinal3.domain.data.User

@AndroidEntryPoint
class SignUpScreen : Fragment(R.layout.screen_signup) {
    private val binding by viewBinding(ScreenSignupBinding::bind)
    private val viewModel: SignUpViewModel by viewModels<SignUpViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.openSignInLiveData.observe(viewLifecycleOwner, openSignIn)
        viewModel.openParentLiveData.observe(viewLifecycleOwner, openParentObserver)

        binding.apply {

            buttonSignIn.setOnClickListener {
                viewModel.openSignInScreen()
            }


            buttonNextSignup.setOnClickListener {
                val email = edittextEmailSignUp.text.toString()
                val password = edittextPasswordSingUp.text.toString()
                viewModel.openParentScreen(email, password)
            }
        }
    }

    private val openSignIn = Observer<Unit> {
        findNavController().navigate(R.id.action_signUpScreen_to_signInScreen)
    }

    private val openParentObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_signUpScreen_to_parentScreen)
    }
}