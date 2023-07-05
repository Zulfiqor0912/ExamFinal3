package uz.gita.examfinal3.presentation.screens.splash

import androidx.lifecycle.LiveData


interface SplashViewModel {
    val introLiveData: LiveData<Unit>

    fun openOnBoardingScreen()
}