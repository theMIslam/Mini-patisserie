package com.london.inai.ui.about

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.london.inai.databinding.FragmentAboutUsBinding

class AboutUsFragment : Fragment() {

    private lateinit var binding: FragmentAboutUsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAboutUsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnArrow.setOnClickListener {
            findNavController().navigateUp()
        }

        // intent instagram
        binding.btnInstagram.setOnClickListener {
            val instagramUrl = "https://www.instagram.com/wiestx1"

            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(instagramUrl)

            val packageManager: PackageManager = requireActivity().packageManager
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(requireContext(), "Instagram app is not installed", Toast.LENGTH_SHORT).show()
            }

            // intent telegram
            binding.btnTelegram.setOnClickListener {

                val telegramIntent = Intent(Intent.ACTION_VIEW)
                telegramIntent.data = Uri.parse("https://t.me/mktmwiest")

                startActivity(telegramIntent)
            }

            // intent whatsapp
            binding.btnWhatsapp.setOnClickListener {
                val phoneNumber = "0708540691"

                val whatsappIntent = Intent(Intent.ACTION_VIEW)
                whatsappIntent.data = Uri.parse("https://wa.me/+996708540691")

                startActivity(whatsappIntent)
            }
        }
    }
}