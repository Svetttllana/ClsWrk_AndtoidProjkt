package com.example.clswrk_androidprojekt.presentation.view.home.items

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.databinding.FragmentSearchBinding
import com.example.clswrk_androidprojekt.presentation.view.auth.auth.LoginViewModel
import com.example.clswrk_androidprojekt.presentation.view.home.service.MusicPlayer
import com.example.clswrk_androidprojekt.utils.App
import com.example.clswrk_androidprojekt.utils.BaseFragment
import com.squareup.picasso.Picasso
import javax.inject.Inject


class SearchFragment : BaseFragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding: FragmentSearchBinding get() = _binding!!



    private val viewModel: SeaechViewModel by viewModels{viewModelFactory}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().applicationContext as App).provideAppComponent().inject(this)




        AnimationUtils.loadAnimation(binding.btStart.context, R.anim.rotate_anim).also {
            binding.btStart.startAnimation(it)
        }

        val animatorSet = AnimatorSet()

        val y = ObjectAnimator.ofFloat(binding.btStart, "scaleY", 2f, 1f)
        val x = ObjectAnimator.ofFloat(binding.btStart, "scaleX", 2f, 1f)
        animatorSet.playTogether(x, y)
        animatorSet.start()


//        val translate = ValueAnimator.ofFloat(2f,2f)
//        translate.addUpdateListener {  animation->
//            val scale = animation.animatedValue.toString().toFloat()
//            binding.btStop.SetscaleX(scale)
//            binding.btStop.SetscaleY(scale)
//        }


        binding.btStart.setOnClickListener {

            requireActivity().startForegroundService(
                Intent(
                    requireContext(),
                    MusicPlayer::class.java
                )
            )

        }

        binding.btStop.setOnClickListener {
            requireActivity().stopService(Intent(requireContext(), MusicPlayer::class.java))

        }



        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(q0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(q0: String?): Boolean {

                viewModel.findItem(q0 ?: "")

                return false

            }
        })
        viewModel.item.observe(viewLifecycleOwner) {
            binding.description.text = it.description
            Picasso.get().load(Uri.parse(it.image)).into(binding.image)
        }


    }
}


