package com.example.clswrk_androidprojekt.presentation.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.clswrk_androidprojekt.R

import com.example.clswrk_androidprojekt.databinding.FragmentLoginBinding
import com.example.clswrk_androidprojekt.presentation.view.home.HomeFragment
import com.example.clswrk_androidprojekt.utils.NavigationExt.fmReplace
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.btnShowCreads.setOnClickListener {
            viewModel.loginUser(
                binding.etUserLogin.text.toString(),
                binding.etUserPassword.text.toString()
            )

        }

        viewModel.nav.observe(viewLifecycleOwner) {
            fmReplace(parentFragmentManager,HomeFragment(),false)

        }

    }

}