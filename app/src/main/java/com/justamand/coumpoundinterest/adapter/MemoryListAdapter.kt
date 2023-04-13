package com.justamand.coumpoundinterest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.justamand.coumpoundinterest.databinding.CalculationItemBinding
import com.justamand.coumpoundinterest.databinding.FragmentMemoryListBinding
import com.justamand.coumpoundinterest.models.Interest

class MemoryListAdapter(
    private val memoryList: ArrayList<Interest>
) : RecyclerView.Adapter<MemoryListAdapter.MemoryListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoryListViewHolder {

        val memoryListElements = CalculationItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MemoryListViewHolder(memoryListElements)
    }

    override fun getItemCount(): Int = memoryList.size

    override fun onBindViewHolder(holder: MemoryListViewHolder, position: Int) {
        holder.tvPresentValue.text = memoryList[position].presentValue.toString()
        holder.tvFutureValue.text = memoryList[position].futureValue.toString()
        holder.tvInterestRate.text = memoryList[position].interestRate.toString()
        holder.tvMonths.text = memoryList[position].months.toString()
        holder.tvOperation.text = memoryList[position].operation.toString()
    }

    inner class MemoryListViewHolder(private val binding: CalculationItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvPresentValue: TextView = binding.tvPresentValue
        val tvFutureValue: TextView = binding.tvFutureValue
        val tvInterestRate: TextView = binding.tvInterestRate
        val tvMonths: TextView = binding.tvMonths
        val tvOperation: TextView = binding.tvOperation
    }
}