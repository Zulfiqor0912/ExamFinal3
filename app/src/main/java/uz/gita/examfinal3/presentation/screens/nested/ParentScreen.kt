package uz.gita.examfinal3.presentation.screens.nested

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.examfinal3.R
import uz.gita.examfinal3.databinding.ScreenParentBinding
import uz.gita.examfinal3.presentation.screens.adapter.ParentAdapter
import uz.gita.examfinal3.presentation.screens.course.CourseScreen
import uz.gita.examfinal3.presentation.screens.profile.ProfileScreen
import uz.gita.examfinal3.presentation.screens.settings.SettingsScreen

class ParentScreen : Fragment(R.layout.screen_parent) {
    private val binding by viewBinding(ScreenParentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ParentAdapter(childFragmentManager, lifecycle)
        binding.apply {
            viewPager2.adapter = adapter
            bottomNavigation.setOnItemSelectedListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.profileScreen -> {
                        childFragmentManager.beginTransaction()
                            .replace(R.id.parent, ProfileScreen())
                            .commit()
                        true
                    }

                    R.id.courseScreen -> {
                        childFragmentManager.beginTransaction()
                            .replace(R.id.parent, CourseScreen())
                            .commit()
                        true
                    }

                    else -> {
                        childFragmentManager.beginTransaction()
                            .replace(R.id.parent, SettingsScreen())
                            .commit()
                        true
                    }
                }
            }
            viewPager2.registerOnPageChangeCallback(callback)
        }


    }


    private val callback: ViewPager2.OnPageChangeCallback =
        object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> binding.bottomNavigation.selectedItemId = R.id.courseScreen
                    1 -> binding.bottomNavigation.selectedItemId = R.id.profileScreen
                    else -> binding.bottomNavigation.selectedItemId = R.id.settingsScreen
                }
            }
        }
}