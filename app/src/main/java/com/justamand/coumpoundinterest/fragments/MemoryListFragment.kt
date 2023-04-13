package com.justamand.coumpoundinterest.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.justamand.coumpoundinterest.R
import com.justamand.coumpoundinterest.adapter.MemoryListAdapter
import com.justamand.coumpoundinterest.databinding.FragmentMemoryListBinding
import com.justamand.coumpoundinterest.models.Interest

class MemoryListFragment(
    private var memory: ArrayList<Interest>
) : Fragment() {

    private var _binding : FragmentMemoryListBinding? = null

    private val binding get() = _binding!!

    private lateinit var adapterMemoryList: MemoryListAdapter
    private val memoryListElements: ArrayList<Interest> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMemoryListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        val recyclerMemoryList = binding.recyclerMemory
        recyclerMemoryList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerMemoryList.setHasFixedSize(true)
        adapterMemoryList = MemoryListAdapter(memoryListElements)
        recyclerMemoryList.adapter = adapterMemoryList
        createList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun createList() {
        memory.forEach {
            memoryListElements.add(it)
        }
        println("added on create list" + memoryListElements)
    }

}