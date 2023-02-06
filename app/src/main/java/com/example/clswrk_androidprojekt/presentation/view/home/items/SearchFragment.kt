package com.example.clswrk_androidprojekt.presentation.view.home.items

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import android.widget.SearchView
import androidx.fragment.app.viewModels
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.databinding.FragmentSearchBinding
import com.example.clswrk_androidprojekt.presentation.view.home.service.MusicPlayer
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding: FragmentSearchBinding get() = _binding!!


    private val viewModel: SeaechViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //first Variant

//        val btn = Button(context)
//        btn.background = context?.getDrawable(R.drawable.chmonya_image)
//        btn.text = context?.getString(R.string.image_view_clicked)
//        binding.root.addView(btn)


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


