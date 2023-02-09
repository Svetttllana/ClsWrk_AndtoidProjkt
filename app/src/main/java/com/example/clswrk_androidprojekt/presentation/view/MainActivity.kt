package com.example.clswrk_androidprojekt.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.databinding.ActivityMainBinding
import com.example.clswrk_androidprojekt.presentation.view.auth.auth.LoginViewModel
import com.example.clswrk_androidprojekt.utils.App
import javax.inject.Inject


class MainActivity : AppCompatActivity(), NavController.OnDestinationChangedListener {


    private lateinit var _binding: ActivityMainBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: MainViewModel by viewModels{viewModelFactory}


    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(_binding.root)

        (applicationContext as App).provideAppComponent().inject(this)

//actionBar?.setDisplayHomeAsUpEnabled(false)

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


            navGraph.startDestination= R.id.loginFragment
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


