package com.london.inai.ui.employee.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.london.inai.ui.employee.model.Employee
import com.london.inai.databinding.ItemEmployeeBinding

class EmployeeAdapter(private val list: ArrayList<Employee>, private val onClick: () -> Unit) :
    Adapter<EmployeeAdapter.EmployeeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        return EmployeeViewHolder(
            ItemEmployeeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class EmployeeViewHolder(private val binding: ItemEmployeeBinding) :
        ViewHolder(binding.root) {
        fun bind(employee: Employee) {
            employee.image?.let { binding.ivAvatar.setImageResource(it) }
            binding.tvName.text = employee.name
            itemView.setOnClickListener {
                onClick()
            }
        }
    }
}