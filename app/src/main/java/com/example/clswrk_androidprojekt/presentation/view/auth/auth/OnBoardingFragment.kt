package com.example.clswrk_androidprojekt.presentation.view.auth.auth


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.clswrk_androidprojekt.databinding.FragmentOnBoardingBinding
import com.example.clswrk_androidprojekt.utils.NavHelper.navigated


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

        viewModel.nav. observe(viewLifecycleOwner) {
            if (it != null) {
                navigated(it.removeFragmentId)


//                findNavController().navigate(R.id.action_onBoardingFragment_to_itemsFragment,
//                    null,
//                    navOptions.build())

                viewModel.finishPerformed()
            }
        }

    }
}

