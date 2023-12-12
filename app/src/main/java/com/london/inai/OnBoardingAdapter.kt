package com.london.inai

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.london.inai.databinding.ItemOnboardBinding

class OnBoardingAdapter(private val onStartClick: () -> Unit) :
    Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val data = arrayListOf(
        OnBoarding(R.drawable.welcome, "Дорогие гурманы и\nсладкоежки!"),
        OnBoarding(
            R.drawable.pastry_cook,
            "Добро пожаловать в\nнаш уютный\nкондитерский дом, где\nкаждый десерт - \nнастоящее\nпроизведение\nискусства,созданное с\nлюбовью и тщательным\nвниманием к деталям."
        ),
        OnBoarding(
            R.drawable.baking,
            "Здесь, в мире\nволшебных вкусов и\nизысканных угощений,\nмы рады приветствовать\nвас как гостей своей\nсладкой семьи."
        ),
        OnBoarding(
            R.drawable.pastry_bag,
            "Будьте готовы к\nпутешевствию по миру\nсладких наслаждений!"
        ),

        )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnboardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoarding: OnBoarding) {
            binding.apply {
                onBoarding.image?.let { ivImage.setImageResource(it) }
                tvTitle.text = onBoarding.title

                btnStart.isVisible = adapterPosition == data.lastIndex
                btnStart.setOnClickListener {
                    onStartClick()
                }
            }
        }
    }
}