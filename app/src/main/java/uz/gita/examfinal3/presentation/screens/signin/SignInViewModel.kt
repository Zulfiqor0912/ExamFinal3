package uz.gita.examfinal3.presentation.screens.signin

import androidx.lifecycle.LiveData

interface SignInViewModel {
    val openSignUpLiveData: LiveData<Unit>
    val openHomeLiveData: LiveData<Unit>

    fun openHomeScreen(email: String, password: String)
    fun openSignUpScreen()


}