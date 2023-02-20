package com.example.clswrk_androidprojekt.presentation.view.home.items

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clswrk_androidprojekt.databinding.FragmentFavoritesBinding
import com.example.clswrk_androidprojekt.presentation.reseiver.AirplaneModeChangeReceiver
import com.example.clswrk_androidprojekt.presentation.reseiver.MyBroadcastReceiver
import com.example.clswrk_androidprojekt.presentation.view.auth.auth.LoginViewModel
import com.example.clswrk_androidprojekt.presentation.view.home.items.adapter.FavoritesAdapter
import com.example.clswrk_androidprojekt.utils.App
import com.example.clswrk_androidprojekt.utils.BaseFragment
import javax.inject.Inject


class FavoritesFragment : BaseFragment() {

    private var _binding: FragmentFavoritesBinding? = null
    private val binding: FragmentFavoritesBinding get() = _binding!!

    private lateinit var favAdapter: FavoritesAdapter


    private val viewModel: FavoritesViewModel by viewModels{viewModelFactory}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoritesBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().applicationContext as App).provideAppComponent().inject(this)
        favAdapter = FavoritesAdapter()

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = favAdapter

        viewModel.getFavorites()



        viewModel.favorite.observe(viewLifecycleOwner) {
            favAdapter.submitList(it)
        }

       val  receiver = AirplaneModeChangeReceiver()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            requireContext().registerReceiver(receiver, it)
        }

        val  receiver2 = MyBroadcastReceiver()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            requireContext().registerReceiver(receiver2, it)
        }
setMessage()


    }
    private fun setMessage(){
        val intent = Intent("MY_ACTION")
        intent.putExtra("KEY", "message")
        requireContext().sendBroadcast(intent)
    }

}
