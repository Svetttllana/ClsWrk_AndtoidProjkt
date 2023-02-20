package com.example.clswrk_androidprojekt.presentation.view.home.items

import android.content.Context.LOCATION_SERVICE
import android.location.LocationListener
import android.location.LocationManager
import android.location.LocationManager.GPS_PROVIDER
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clswrk_androidprojekt.databinding.FragmentFavoritesBinding
import com.example.clswrk_androidprojekt.presentation.view.home.items.adapter.FavoritesAdapter
import com.example.clswrk_androidprojekt.utils.App
import com.example.clswrk_androidprojekt.utils.BaseFragment


class FavoritesFragment : BaseFragment() {

    private var _binding: FragmentFavoritesBinding? = null
    private val binding: FragmentFavoritesBinding get() = _binding!!

    private lateinit var favAdapter: FavoritesAdapter


    private val viewModel: FavoritesViewModel by viewModels { viewModelFactory }

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


        var locationManager: LocationManager? = null

        locationManager = requireActivity().getSystemService(LOCATION_SERVICE) as LocationManager?

        try {
            locationManager?.requestLocationUpdates(
                GPS_PROVIDER,
                0L,
                0.0f,
                locationListener
            )

        } catch (e: Exception) {
            Log.w("error", "while asseting location")
        }
    }

        private val locationListener = LocationListener {
            Toast.makeText(
                requireContext(),
                "long:${it.longitude}lat: ${it.latitude}",
                Toast.LENGTH_SHORT

            ).show()
        }

    }

