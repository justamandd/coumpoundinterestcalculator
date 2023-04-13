package com.justamand.coumpoundinterest.fragments.calculation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.justamand.coumpoundinterest.R
import com.justamand.coumpoundinterest.databinding.FragmentPresentValueBinding
import com.justamand.coumpoundinterest.models.Interest
import com.justamand.coumpoundinterest.models.Operation
import kotlin.math.pow

class PresentValueFragment(
    val memory: ArrayList<Interest>
) : Fragment() {

    private var _binding: FragmentPresentValueBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPresentValueBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.calculate.setOnClickListener { view ->
            if (binding.futureValue.editText?.text.toString().isNotEmpty()
                && binding.interestRate.editText?.text.toString().isNotEmpty()
                && binding.months.editText?.text.toString().isNotEmpty()) {

                memory.add(
                    Interest(
                        presentValue = presentValue(
                            binding.futureValue.editText?.text.toString().toDouble(),
                            binding.interestRate.editText?.text.toString().toDouble()/100,
                            binding.months.editText?.text.toString().toUShort()
                        ),

                        futureValue = binding.futureValue.editText?.text.toString().toDouble(),
                        binding.interestRate.editText?.text.toString().toDouble(),
                        binding.months.editText?.text.toString().toUShort(),
                        operation = Operation.Present
                    )
                )
                println(memory)


                binding.presentValueResult.text = memory[memory.size - 1].presentValue.toString()
            }
        }
    }

    fun presentValue(
        futureValue: Double,
        interestRate: Double,
        months: UShort
    ): Double {
        return futureValue / (1 + interestRate).pow(months.toDouble())
    }

}