package com.london.inai.ui.pastry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.london.inai.R
import com.london.inai.databinding.FragmentPastryBinding
import com.london.inai.ui.employee.adapter.EmployeeAdapter
import com.london.inai.ui.employee.model.Employee

class PastryFragment : Fragment() {

    private lateinit var binding: FragmentPastryBinding
    private lateinit var list: ArrayList<Employee>
    private lateinit var adapter: EmployeeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPastryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        setAdapter()
        binding.btnArrow.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun loadData() {
        list = ArrayList()
        list.apply {
            add(Employee("Торт наполеон", R.drawable.napoleon))
            add(Employee("Торт наполеон", R.drawable.napoleon))
            add(Employee("Торт наполеон", R.drawable.napoleon))
            add(Employee("Торт наполеон", R.drawable.napoleon))
            add(Employee("Торт наполеон", R.drawable.napoleon))
            add(Employee("Торт наполеон", R.drawable.napoleon))
            add(Employee("Торт наполеон", R.drawable.napoleon))
            add(Employee("Торт наполеон", R.drawable.napoleon))
            add(Employee("Торт наполеон", R.drawable.napoleon))
            add(Employee("Торт наполеон", R.drawable.napoleon))
        }
    }

    private fun setAdapter() {
        adapter = EmployeeAdapter(list, this::onClick)
        binding.recyclerView.adapter = adapter
    }

    private fun onClick() {
        findNavController().navigate(R.id.compositionFragment)
    }
}