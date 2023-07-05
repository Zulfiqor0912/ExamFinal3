package uz.gita.examfinal3.presentation.screens.signin


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.examfinal3.domain.repositories.AuthRepositoryImpl
import javax.inject.Inject

@HiltViewModel
class SignInViewModelImpl @Inject constructor(
    private val repositoryImpl: AuthRepositoryImpl
) : SignInViewModel, ViewModel() {
    override val openSignUpLiveData = MutableLiveData<Unit>()
    override val openHomeLiveData = MutableLiveData<Unit>()

    override fun openHomeScreen(email: String, password: String) {
        repositoryImpl.signIn(email, password).onEach {
            it.onSuccess {
                openHomeLiveData.value = Unit
            }
            it.onFailure {

            }
        }.launchIn(viewModelScope)
    }

    override fun openSignUpScreen() {
        openSignUpLiveData.value = Unit
    }
}