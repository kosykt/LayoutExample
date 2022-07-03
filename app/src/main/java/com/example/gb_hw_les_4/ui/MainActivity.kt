package com.example.gb_hw_les_4.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.gb_hw_les_4.R
import com.example.gb_hw_les_4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.main_container) as NavHostFragment
        navController = navHostFragment.navController
        initBottomNavBar()
        initToolBar()
    }

    private fun initToolBar() {
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.mainToolBar.setupWithNavController(navController, appBarConfiguration)
        setSupportActionBar(binding.mainToolBar)
    }

    private fun initBottomNavBar() {
        val bottomNavView = binding.mainBnv
        NavigationUI.setupWithNavController(bottomNavView, navController)
        bottomNavView.setupWithNavController(navController)
    }
}