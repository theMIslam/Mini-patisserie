package com.london.inai

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.london.inai.databinding.FragmentAuthorizationBinding

class AuthorizationFragment : Fragment() {

    private lateinit var binding: FragmentAuthorizationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthorizationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {
        binding.btnEnterViaGoogle.setOnClickListener {
            findNavController().navigate(R.id.accountFragment)
        }
        binding.btnContinueWithApple.setOnClickListener {
            findNavController().navigate(R.id.accountFragment)
        }
        binding.btnContinueWithVk.setOnClickListener {
            findNavController().navigate(R.id.accountFragment)
        }
    }
}