package com.example.clswrk_androidprojekt.presentation.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels

import androidx.navigation.fragment.findNavController
import com.example.clswrk_androidprojekt.utils.BundleConstans.IMAGE_VIEW
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.databinding.FragmentDetailsBinding

import com.example.clswrk_androidprojekt.utils.BundleConstans.DATE
import com.example.clswrk_androidprojekt.utils.BundleConstans.NAME
import com.example.clswrk_androidprojekt.utils.NavHelper.replaceGraph

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding: FragmentDetailsBinding get() = _binding!!

    private val viewModel : DetailsViewModel by viewModels ()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      _binding =FragmentDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detailsName = view.findViewById<TextView>(R.id.detailsName)
        val detailsDate = view.findViewById<TextView>(R.id.detailsDate)
        val detailsImage = view.findViewById<ImageView>(R.id.detailsImage)

        val bundle = arguments


        bundle?.let{safeBundle ->
            val name = safeBundle.getString(NAME)
            val date = safeBundle.getString(DATE)
            val image = safeBundle.getInt(IMAGE_VIEW)

            detailsName.text = name
            detailsDate.text = date
            detailsImage.setBackgroundResource(image)

        }


       binding.btnLogaut.setOnClickListener{
            viewModel.logautUser()
        }

        viewModel.nav.observe(viewLifecycleOwner){

            if (it != null) {
                replaceGraph(it)
            }

        }

    }



}