package uz.gita.examfinal3.presentation.screens.signup

import androidx.lifecycle.LiveData
import uz.gita.examfinal3.domain.data.User

interface SignUpViewModel {
    val openParentLiveData: LiveData<Unit>
    val openSignInLiveData: LiveData<Unit>

    fun openParentScreen(email: String, password: String)
    fun openSignInScreen()
}