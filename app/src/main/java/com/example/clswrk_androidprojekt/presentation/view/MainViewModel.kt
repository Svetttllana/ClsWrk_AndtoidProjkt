package com.example.clswrk_androidprojekt.presentation.view

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDestination
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.domain.auth.AuthInteractor
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
) : ViewModel() {

    private val _nav = MutableLiveData<Int>()
    val nav: LiveData<Int> = _nav

    private val _visibility = MutableLiveData<Int>()
    val visibility: LiveData<Int> = _visibility


    fun checkUserExists() {
        viewModelScope.launch {
            val doesUserExist = authInteractor.checkUserExists()
            _nav.value = when (doesUserExist) {
                true -> R.navigation.main_graph
                false -> R.navigation.auth_graph
            }
        }

    }


    fun destinationChanged(destination: NavDestination) {
        if (destination.id == R.id.loginFragment || destination.id == R.id.homeFragment) {
            _visibility.value = View.GONE

        } else {
            _visibility.value = View.VISIBLE

        }

    }

}

