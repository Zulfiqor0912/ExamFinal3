package uz.gita.examfinal3.presentation.screens.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModelIMpl @Inject constructor(): SplashViewModel, ViewModel() {
    override val introLiveData = MutableLiveData<Unit>()

    override fun openOnBoardingScreen() {
        introLiveData.value = Unit
    }

}