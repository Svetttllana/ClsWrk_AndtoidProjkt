package com.example.clswrk_androidprojekt.presentation.view.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.databinding.FragmentHomeBinding
import com.example.clswrk_androidprojekt.presentation.auth.OnBoardingFragment
import com.example.clswrk_androidprojekt.utils.CoroutinesExample
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*


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

        //это тип у нас метод выполняется теперь в потоке . Прекол канешна.
        viewModel.showUserData()

CoroutinesExample().testCoroutineCancel()

        // это юзаем для долговременных акций. так мы еще добавляем деспатчер
//     CoroutineScope( Dispatchers.IO).launch {
//
//     }


        // fmReplace(parentFragmentManager,OnBoardingFragment(),false)
        binding.dtnGoToOnBoarding.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.activity_container, OnBoardingFragment())
                .commit()
        }

        viewModel.userCreds.observe(viewLifecycleOwner) {
            binding.tvUserCreads.text = "${it.userName} \n ${it.userPassword}"

        }

    }

}