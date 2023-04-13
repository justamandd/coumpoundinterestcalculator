package com.justamand.coumpoundinterest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.justamand.coumpoundinterest.databinding.ActivityMainBinding
import com.justamand.coumpoundinterest.fragments.MemoryListFragment
import com.justamand.coumpoundinterest.fragments.calculation.FutureValueFragment
import com.justamand.coumpoundinterest.fragments.calculation.PresentValueFragment
import com.justamand.coumpoundinterest.models.Interest

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var memory: ArrayList<Interest> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.future -> {
                    replaceFragment(FutureValueFragment(memory))
                    true
                }
                R.id.present -> {
                    replaceFragment(PresentValueFragment(memory))
                    true
                }
                R.id.memory -> {
                    replaceFragment(MemoryListFragment(memory))
                    true
                }
                else -> false
            }
        }
    }

    override fun onStart() {
        super.onStart()
        replaceFragment(MemoryListFragment(memory))
    }

    private fun replaceFragment(fragment: Fragment) {
        var fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }
}