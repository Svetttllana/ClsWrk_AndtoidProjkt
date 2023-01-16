package com.example.clswrk_androidprojekt.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.databinding.ActivityMainBinding
import com.example.clswrk_androidprojekt.presentation.auth.LoginFragment
import com.example.clswrk_androidprojekt.presentation.view.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlin.random.Random

@AndroidEntryPoint

class MainActivity : AppCompatActivity(), NavController.OnDestinationChangedListener {


    private lateinit var _binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(_binding.root)

actionBar?.setDisplayHomeAsUpEnabled(false)

        viewModel.checkUserExists()

        navHostFragment = supportFragmentManager.findFragmentById(
            R.id.fragmentContainerView
        ) as NavHostFragment




        navController = navHostFragment.navController

        viewModel.nav.observe(this) {

            navController.graph = getNavGraph()

            //navController.setGraph(it)

        }


        navController.addOnDestinationChangedListener(this)

        _binding.buttomNavigation.setupWithNavController(navController)

        val btnav = AppBarConfiguration(
            setOf(R.id.onBoardingFragment, R.id.itemsFragment)
        )

        NavigationUI.setupActionBarWithNavController(this, navController, btnav)




        viewModel.visibility.observe(this) {

            _binding.buttomNavigation.visibility = it
        }



    }

    private fun getNavGraph():NavGraph {
        val navGraph = navHostFragment.navController.navInflater.inflate(
            R.navigation.auth_graph
        )

        val random = (1..3).random()
        if (random == 1) {
            navGraph.startDestination = R.id.loginFragment
        } else {
            navGraph.startDestination = R.id.homeFragment
        }

        return  navGraph




    }


    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        viewModel.destinationChanged(destination)
    }

    override fun onDestroy() {
        super.onDestroy()
        navController.removeOnDestinationChangedListener(this)

    }

}


