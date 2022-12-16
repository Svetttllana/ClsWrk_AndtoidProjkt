package com.example.clswrk_androidprojekt.utils


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.clswrk_androidprojekt.R

object NavigationExt {


    fun fmReplace(
        parentFragmentManager: FragmentManager,
        fragment: Fragment,
        addToBackStack: Boolean
    ) {
        if (addToBackStack) {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.activity_container, fragment)
                .addToBackStack("details")
                .commit()
        } else {

            parentFragmentManager
                .beginTransaction()
                .replace(R.id.activity_container, fragment)
                .commit()
        }
    }
}