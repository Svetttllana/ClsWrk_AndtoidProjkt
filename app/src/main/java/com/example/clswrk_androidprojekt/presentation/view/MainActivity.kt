package com.example.clswrk_androidprojekt.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.databinding.ActivityMainBinding
import com.example.clswrk_androidprojekt.presentation.auth.LoginFragment
import com.example.clswrk_androidprojekt.presentation.view.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint

class MainActivity : AppCompatActivity(), MainView {


    private var _binding: ActivityMainBinding? = null

    @Inject
    lateinit var mainPresenter: MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(_binding!!.root)



        mainPresenter.setView(this)
        mainPresenter.checkUserExists()


    }

    override fun UserExistsResult(userExists: Boolean) {

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(
            R.id.activity_container,
            when (userExists) {
                true -> HomeFragment()
                false -> LoginFragment()
            }
        )

        fragmentTransaction.commit()
    }
}


