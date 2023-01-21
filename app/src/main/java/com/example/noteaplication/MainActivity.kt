package com.example.noteaplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.noteaplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    var homeFragment = HomeFragment.newInstance()
    var cartFragment = SafeFragment.newInstance()

    var activeFragment: Fragment = homeFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportFragmentManager.beginTransaction().add(
            R.id.container, homeFragment, homeFragment.tag
        ).hide(homeFragment).commit()

        supportFragmentManager.beginTransaction().add(
            R.id.container, cartFragment, cartFragment.tag
        ).hide(cartFragment).commit()

        supportFragmentManager.beginTransaction().show(
            activeFragment
        ).commit()

        binding.btnNav.setOnItemSelectedListener {
            if (it.itemId == R.id.home) {
                supportFragmentManager.beginTransaction().hide(
                    activeFragment
                ).show(homeFragment).commit()
                activeFragment = homeFragment
            }
            else if (it.itemId == R.id.safe){
                supportFragmentManager.beginTransaction().hide(
                    activeFragment
                ).show(cartFragment).commit()
                activeFragment = cartFragment
            }
            return@setOnItemSelectedListener true
        }
    }
}