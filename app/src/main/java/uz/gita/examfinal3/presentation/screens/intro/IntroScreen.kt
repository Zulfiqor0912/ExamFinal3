package uz.gita.examfinal3.presentation.screens.intro

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.examfinal3.R
import uz.gita.examfinal3.databinding.ScreenIntrosBinding
import uz.gita.examfinal3.presentation.screens.adapter.IntroAdapter


@AndroidEntryPoint
class IntroScreen : Fragment(R.layout.screen_intros) {
    private val binding by viewBinding(ScreenIntrosBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = IntroAdapter(requireActivity())
        binding.apply {
            viewPager.adapter = adapter
            viewPager.isUserInputEnabled = false

            viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)

                    when (position) {

                    }
                }
            })

            buttonNext.setOnClickListener {
                if (viewPager.currentItem == 2) findNavController().navigate(R.id.action_introScreen_to_signIn)
                else viewPager.currentItem++
            }

            dotsIndicator.attachTo(viewPager)
        }
    }
}