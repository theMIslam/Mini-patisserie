package com.london.inai

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.london.inai.databinding.FragmentOnBoardingBinding
import me.relex.circleindicator.CircleIndicator3

class OnBoardingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardingBinding
    private lateinit var adapter: OnBoardingAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        setIndicator()
    }

    private fun setAdapter() {
        adapter = OnBoardingAdapter(this::onStartClick)
        binding.viewPager.adapter = adapter
    }

    private fun setIndicator() {
        val indicator: CircleIndicator3 =binding.indicator
        val viewPager = binding.viewPager
        indicator.setViewPager(viewPager)
    }

    private fun onStartClick() {
        findNavController().navigate(R.id.mainFragment)
    }
}