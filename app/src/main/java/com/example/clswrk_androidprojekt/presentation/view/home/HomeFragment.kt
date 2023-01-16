package com.example.clswrk_androidprojekt.presentation.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.databinding.FragmentHomeBinding
import com.example.clswrk_androidprojekt.utils.NavHelper.replaceGraph
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.showUserData()

        binding.dtnGoToOnBoarding.setOnClickListener {

            findNavController().setGraph(R.navigation.main_graph)


        }

        viewModel.userCreds.observe(viewLifecycleOwner) {
            binding.tvUserCreads.text = "${it.userName} \n ${it.userPassword}"

        }

    }

}