package uz.gita.examfinal3.presentation.screens.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.examfinal3.R
import uz.gita.examfinal3.databinding.ScreenSettingBinding
import uz.gita.examfinal3.domain.data.User

class SettingsScreen : Fragment(R.layout.screen_setting) {
    private val binding by viewBinding(ScreenSettingBinding::bind)
//    private val args by navArgs<SettingsScreenArgs>()
//    private lateinit var data: User

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        data = args.data

        binding.apply {
//            name.text = data.name
//            email.text = data.email
//            password.text = data.password
        }
    }
}