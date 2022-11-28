package com.example.clswrk_androidprojekt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


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
            parentFragmentManager.
            beginTransaction()
                .replace(R.id.activity_container,ItemsFragment())
                .addToBackStack("details")
                .commit()
        }

    }
}

