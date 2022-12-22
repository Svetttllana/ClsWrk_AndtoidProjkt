package com.example.clswrk_androidprojekt.presentation.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.clswrk_androidprojekt.utils.BundleConstans.IMAGE_VIEW
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.databinding.FragmentDetailsBinding
import com.example.clswrk_androidprojekt.presentation.auth.LoginFragment
import com.example.clswrk_androidprojekt.utils.BundleConstans.DATE
import com.example.clswrk_androidprojekt.utils.BundleConstans.NAME
import com.example.clswrk_androidprojekt.utils.NavigationExt.fmReplace
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailsFragment : Fragment(), DetailsView {

    private var _binding: FragmentDetailsBinding? = null
    private val binding: FragmentDetailsBinding get() = _binding!!

    @Inject
    lateinit var detailsPresenter: DetailsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailsPresenter.setView(this)

        val detailsName = view.findViewById<TextView>(R.id.detailsName)
        val detailsDate = view.findViewById<TextView>(R.id.detailsDate)
        val detailsImage = view.findViewById<ImageView>(R.id.detailsImage)

        val bundle = arguments

// тут потом пересмотреть может быть кхрашш
        bundle?.let { safeBundle ->
            detailsPresenter.getArguments(
                safeBundle.getString(NAME),
                safeBundle.getString(DATE),
                safeBundle.getInt(IMAGE_VIEW)
            )
        }

        binding.btnLogaut.setOnClickListener {
            detailsPresenter.logautUser()
        }


    }

    override fun userLoggeout() {
        fmReplace(parentFragmentManager, LoginFragment(), false)
    }

    override fun displayItemData(name: String, date: String, imageView: Int) {
        binding.detailsName.text = name
        binding.detailsDate.text = date
        binding.detailsImage.setBackgroundResource(imageView)
    }


}