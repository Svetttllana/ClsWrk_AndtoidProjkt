package com.example.clswrk_androidprojekt.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.presentation.view.NavigationExt.fmReplace


class OnBoardingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_on_boarding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val onBoardingFinisged = view.findViewById<Button>(R.id.btn1)
        onBoardingFinisged.setOnClickListener {

fmReplace(parentFragmentManager,ItemsFragment(),false)

        }

    }
}

