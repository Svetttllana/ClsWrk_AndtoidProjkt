package com.example.clswrk_androidprojekt.dataBinding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clswrk_androidprojekt.OnBoardingFragment
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.databinding.FragmentLoginBinding
import com.example.clswrk_androidprojekt.databinding.FragmentOnBoardingBinding
import com.example.clswrk_androidprojekt.presentation.view.NavigationExt.fmReplace


class LoginFragment : Fragment() {
private var _binding : FragmentLoginBinding?=null
    private val binding get() = _binding!!

    private val viewModel:LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel=viewModel
        binding.viewHandler=ViewHandler()
        binding.lifecycleOwner=viewLifecycleOwner

    }

    inner class ViewHandler{

      fun goToTheOnBoarding(){

          fmReplace(parentFragmentManager,OnBoardingFragment(),false)

      }



    }



}