package uz.gita.examfinal3.presentation.screens.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.gita.examfinal3.presentation.screens.intro.FirstIntro
import uz.gita.examfinal3.presentation.screens.intro.SecondIntro
import uz.gita.examfinal3.presentation.screens.intro.ThirdIntro

class IntroAdapter(fr: FragmentActivity) : FragmentStateAdapter(fr) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FirstIntro()
            1 -> SecondIntro()
            else -> ThirdIntro()
        }
    }

}