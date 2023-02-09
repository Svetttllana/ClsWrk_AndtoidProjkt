package com.example.clswrk_androidprojekt.presentation.view.auth.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.clswrk_androidprojekt.databinding.FragmentLoginBinding
import com.example.clswrk_androidprojekt.utils.App
import com.example.clswrk_androidprojekt.utils.BaseFragment
import com.example.clswrk_androidprojekt.utils.NavHelper.navigated
import javax.inject.Inject


class LoginFragment : BaseFragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!



    private val viewModel: LoginViewModel by viewModels{viewModelFactory}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().applicationContext as App).provideAppComponent().inject(this)


        binding.btnShowCreads.setOnClickListener {
            viewModel.loginUser(
                binding.etUserLogin.text.toString(),
                binding.etUserPassword.text.toString()
            )

        }

        viewModel.nav.observe(viewLifecycleOwner) {
            if (it!=null) {
                navigated(it)
                viewModel.userNavigated()


            }

        }

    }

}