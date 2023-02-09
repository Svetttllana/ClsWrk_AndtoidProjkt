package com.example.clswrk_androidprojekt.presentation.view.home.items

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.databinding.FragmentDetailsBinding
import com.example.clswrk_androidprojekt.presentation.view.auth.auth.LoginViewModel
import com.example.clswrk_androidprojekt.utils.App
import com.example.clswrk_androidprojekt.utils.BaseFragment
import com.example.clswrk_androidprojekt.utils.BundleConstans.IMAGE_VIEW
import com.squareup.picasso.Picasso
import javax.inject.Inject


class DetailsFragment : BaseFragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding: FragmentDetailsBinding get() = _binding!!



    private val viewModel: DetailsViewModel by viewModels{viewModelFactory}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().applicationContext as App).provideAppComponent().inject(this)
        val detailsName = view.findViewById<TextView>(R.id.detailsName)
        val detailsDate = view.findViewById<TextView>(R.id.detailsDate)
        val detailsImage = view.findViewById<ImageView>(R.id.detailsImage)

        val bundle = arguments


        bundle?.let { safeBundle ->

            val description = safeBundle.getString("description")
            val image = safeBundle.getString(IMAGE_VIEW)


            detailsDate.text = description
            Picasso.get().load(Uri.parse(image)).into(detailsImage)


        }


        binding.btnLogaut.setOnClickListener {
        binding.btnLogaut.isPressed = !it.isPressed
        // viewModel.logautUser()
        }

        viewModel.nav.observe(viewLifecycleOwner) {

            if (it != null) {
                val navGraph = findNavController().navInflater.inflate(
                    it
                )
                navGraph.startDestination = R.id.loginFragment
                findNavController().graph = navGraph

            }

        }

    }

}