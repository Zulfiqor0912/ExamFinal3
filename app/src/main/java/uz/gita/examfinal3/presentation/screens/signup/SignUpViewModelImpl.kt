package uz.gita.examfinal3.presentation.screens.signup

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.examfinal3.domain.data.User
import uz.gita.examfinal3.domain.repositories.AuthRepositoryImpl
import javax.inject.Inject


@HiltViewModel
class SignUpViewModelImpl @Inject constructor(
    private val authRepositoryImpl: AuthRepositoryImpl
) : SignUpViewModel, ViewModel() {
    override val openParentLiveData = MutableLiveData<Unit>()
    override val openSignInLiveData = MutableLiveData<Unit>()

    override fun openParentScreen(email: String, password: String) {
        authRepositoryImpl.signUp(email, password).onEach {
            it.onSuccess {
                openParentLiveData.value = Unit
                Log.d("TTT", "SuccesSignUp")
            }
            it.onFailure {
                Log.d("TTT", "FailureSignUp")
            }

        }
            .launchIn(viewModelScope)
    }

    override fun openSignInScreen() {
        openSignInLiveData.value = Unit
    }
}