package com.example.clswrk_androidprojekt.presentation.view.auth.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.clswrk_androidprojekt.R

import com.example.clswrk_androidprojekt.databinding.FragmentOnBoardingBinding
import com.example.clswrk_androidprojekt.utils.NavHelper.navigateWithDelitedBackStack


class OnBoardingFragment : Fragment() {

    private val viewModel: OnBoardingViewModel by viewModels()


    private var _binding: FragmentOnBoardingBinding? = null
    private val binding: FragmentOnBoardingBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentOnBoardingBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner



        viewModel.nav.observe(viewLifecycleOwner) {
            if (it != null) {
                val navOptions = NavOptions.Builder()
                navigateWithDelitedBackStack(
                    it.destinationId,
                    it.removeFragmentId

                )

//                findNavController().navigate(R.id.action_onBoardingFragment_to_itemsFragment,
//                    null,
//                    navOptions.build())

                viewModel.finishPerformed()
            }
        }

    }
}

