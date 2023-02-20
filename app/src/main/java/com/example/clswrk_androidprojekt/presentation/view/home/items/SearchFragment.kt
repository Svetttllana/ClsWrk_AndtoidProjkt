package com.example.clswrk_androidprojekt.presentation.view.home.items

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
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

        runHandler()


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

//
//        binding.btStart.setOnClickListener {
//
//            requireActivity().startForegroundService(
//                Intent(
//                    requireContext(),
//                    MusicPlayer::class.java
//                )
//            )
//
//        }

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


    private fun runHandler(){
        var backgroundHandler: Handler? = null

        //Creating a background thread.
        val backgroundThread = Thread {
            //Creating a Looper for this thread.
            Looper.prepare()

            //Looper.myLooper() gives you Looper for current Thread.
            val myLooper = Looper.myLooper()!!

            //Creating a Handler for given Looper object.
            backgroundHandler = Handler(myLooper) { msg ->

                //Processing incoming messages for this Handler.
                //Receiving extras from Message
                val bundle: Bundle? = msg.data

                Log.d("", "Handler:: Extras: ${bundle}")

                Log.d("", "Handler:: Background Thread ID ${Thread.currentThread().id}")

                //myLooper.quit()
                true
            }

            Looper.loop()
        }
        backgroundThread.start()


        //Click listener on a Button
        binding.btnNashat.setOnClickListener {
            Log.d("", "Handler:: UI Thread ID ${Thread.currentThread().id}")

            //Executing code on backgroundThread using Handler.
            backgroundHandler!!.post {
                //Here, you'll note that Thread's ID is of backgroundThread.
                Log.d("", "Handler:: Background Thread ID ${Thread.currentThread().id}")
            }

            // Now, sending data on backgroundThread using Message object. Handler's handleMessage(msg: Message?) method will receive this Message and perform appropriate action.
            val extras = Bundle()
            extras.putInt("PRICE", 100)
            extras.putString("PRODUCT_NAME", "Table Lamp")

            val message = Message.obtain(backgroundHandler)
            message.data = extras

            backgroundHandler?.sendMessage(message)
        }
    }

}


