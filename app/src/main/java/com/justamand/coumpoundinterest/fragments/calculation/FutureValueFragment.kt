package com.justamand.coumpoundinterest.fragments.calculation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.justamand.coumpoundinterest.databinding.FragmentFutureValueBinding
import com.justamand.coumpoundinterest.models.Interest
import com.justamand.coumpoundinterest.models.Operation
import kotlin.math.pow


class FutureValueFragment(
    val memory: ArrayList<Interest>
) : Fragment() {

    private var _binding : FragmentFutureValueBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFutureValueBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.calculate.setOnClickListener { view ->
            if (binding.presentValue.editText?.text.toString().isNotEmpty()
                && binding.interestRate.editText?.text.toString().isNotEmpty()
                && binding.months.editText?.text.toString().isNotEmpty()) {

                memory.add(
                    Interest(
                        presentValue = binding.presentValue.editText?.text.toString().toDouble(),
                        futureValue = futureValue(
                            binding.presentValue.editText?.text.toString().toDouble(),
                            binding.interestRate.editText?.text.toString().toDouble()/100,
                            binding.months.editText?.text.toString().toUShort()
                        ),
                        binding.interestRate.editText?.text.toString().toDouble(),
                        binding.months.editText?.text.toString().toUShort(),
                        operation = Operation.Future
                    )
                )
                println(memory)

                binding.futureValueResult.text = memory[memory.size - 1].futureValue.toString()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun futureValue(
        presentValue: Double,
        interestRate: Double,
        months: UShort
    ): Double {
        return presentValue * (1 + interestRate).pow(months.toDouble())
    }
}