package com.tengizmkcorp.food_delivery.ui

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tengizmkcorp.food_delivery.R
import com.tengizmkcorp.food_delivery.databinding.ActivityMainBinding
import com.tengizmkcorp.food_delivery.extension.uncheckAllItems
import kotlinx.coroutines.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var bottomNavigation: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setup()
        listeners()
    }

    private fun setup() {
        navController = binding.fragmentContainerView.getFragment<NavHostFragment>().navController
        bottomNavigation = binding.bottomNavigationView
        binding.bottomNavigationView.setOnItemSelectedListener {
            binding.btnSettings.imageTintList =
                ColorStateList.valueOf(ContextCompat.getColor(this, R.color.grey_700))
            when (it.itemId) {
                R.id.discoverFragment -> {
                    navController.navigate(R.id.discoverFragment)
                    true
                }
                R.id.restaurantFragment -> {
                    navController.navigate(R.id.restaurantFragment)
                    true
                }
                R.id.favoriteFragment -> {
                    navController.navigate(R.id.favoriteFragment)
                    true
                }
                else -> false
            }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun listeners() {
        val stnBtn=binding.btnSettings
        stnBtn.setOnClickListener {
            binding.btnSettings.imageTintList =
                ColorStateList.valueOf(ContextCompat.getColor(this, R.color.red_500))
            navController.navigate(R.id.settingsFragment)
            bottomNavigation.uncheckAllItems()
            bottomNavigation.menu.setGroupCheckable(0, true, true)
        }
        stnBtn.setOnLongClickListener {
            binding.btnSettingsLabel.visibility = View.VISIBLE
            true
        }
        stnBtn.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_UP -> {
                    // Do something after the user releases his touch
                    GlobalScope.launch {
                        delay(2000)
                        withContext(Dispatchers.Main) {
                            binding.btnSettingsLabel.visibility = View.GONE
                        }
                    }
                }
            }
            false
        }



    }

}