package uz.gita.examfinal3.presentation.screens.adapter

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.gita.examfinal3.presentation.screens.course.CourseScreen
import uz.gita.examfinal3.presentation.screens.profile.ProfileScreen
import uz.gita.examfinal3.presentation.screens.settings.SettingsScreen

class ParentAdapter(fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CourseScreen().apply {
                arguments = bundleOf(Pair("POS", position))
            }

            1 -> ProfileScreen().apply {
                arguments = bundleOf(Pair("POS", position))
            }

            else -> SettingsScreen().apply {
                arguments = bundleOf(Pair("POS", position))
            }
        }
    }
}