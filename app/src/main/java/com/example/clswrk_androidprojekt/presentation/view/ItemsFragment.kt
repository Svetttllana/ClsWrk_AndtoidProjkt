package com.example.clswrk_androidprojekt.presentation.view

import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.presentation.view.adapter.ItemsAdapter
import com.example.clswrk_androidprojekt.presentation.view.adapter.listener.ItemsListener


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clswrk_androidprojekt.data.ItemsRepositoryImpl
import com.example.clswrk_androidprojekt.domain.ItemsInteractor
import com.example.clswrk_androidprojekt.presentation.view.NavigationExt.fmReplace

import com.example.clswrk_androidprojekt.utils.BundleConstans.IMAGE_VIEW
import com.example.clswrk_androidprojekt.utils.BundleConstans.DATE
import com.example.clswrk_androidprojekt.utils.BundleConstans.NAME


class ItemsFragment : Fragment(), ItemsListener {


    private lateinit var itemsAdapter: ItemsAdapter
    private val viewModel: ItemsViewModel by viewModels{
      ItemsViewModelFactory(ItemsInteractor(ItemsRepositoryImpl()))

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsAdapter = ItemsAdapter(this)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = itemsAdapter

        viewModel.getData()
        viewModel.items.observe(viewLifecycleOwner) { listItems ->
            itemsAdapter.submitList(listItems)
        }
        viewModel.msg.observe(viewLifecycleOwner) { msg ->
            Toast.makeText(context, getString(msg), Toast.LENGTH_SHORT).show()
            Log.w("str", getString(msg))
        }
        viewModel.bundle.observe(viewLifecycleOwner) { navBundle ->
            if (navBundle != null) {
                val detailsFragment = DetailsFragment()
                val bundle = Bundle()
                bundle.putString(NAME, navBundle.name)
                bundle.putString(DATE, navBundle.date)
                bundle.putInt(IMAGE_VIEW, navBundle.image)

                detailsFragment.arguments = bundle


//                parentFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.activity_container, detailsFragment)
//                    .addToBackStack("Details")
//                    .commit()
                    viewModel.userNavigated()
                //NavigationExt.
                fmReplace(parentFragmentManager,DetailsFragment(),true)
            }

        }

    }


    override fun onClick() {
        viewModel.imageViewClicked()
    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {
        viewModel.elementClicked(name, date, imageView)
    }


}










