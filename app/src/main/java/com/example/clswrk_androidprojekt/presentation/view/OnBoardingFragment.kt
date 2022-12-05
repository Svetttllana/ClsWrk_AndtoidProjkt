package com.example.clswrk_androidprojekt.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.databinding.FragmentOnBoardingBinding


class OnBoardingFragment : Fragment() {
private var _viewBinding:FragmentOnBoardingBinding? = null
    private val viewBinding get()=_viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
_viewBinding = FragmentOnBoardingBinding.inflate(inflater)
        return  viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



      viewBinding.btn1.setOnClickListener {
            parentFragmentManager.
            beginTransaction()
                .replace(R.id.activity_container, ItemsFragment())
                .addToBackStack("details")
                                .commit()
        }

    }
}

