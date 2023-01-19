package com.example.clswrk_androidprojekt.presentation.view.home


import com.example.clswrk_androidprojekt.presentation.listener.ItemsListener


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clswrk_androidprojekt.*
import com.example.clswrk_androidprojekt.presentation.adapter.ItemsAdapter
import com.example.clswrk_androidprojekt.utils.BundleConstans.IMAGE_VIEW
import com.example.clswrk_androidprojekt.utils.navigateWithBandl

import dagger.hilt.android.AndroidEntryPoint

//Dont use because it is cringe
const val NAME = "name"

@AndroidEntryPoint
class ItemsFragment : Fragment(), ItemsListener {


    private lateinit var itemsAdapter: ItemsAdapter
    private val viewModel: ItemsViewModel by viewModels()


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
        viewModel.bundle.observe(viewLifecycleOwner) { it ->
            if (it != null) {
                val bundle = Bundle()
                bundle.putString("description", it.description)
                bundle.putString(IMAGE_VIEW, it.image)


                navigateWithBandl(
                    it.destinationiD,
                    bundle
                )

                viewModel.userNavigated()
            }

            viewModel.error.observe(viewLifecycleOwner) {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            }

        }

    }


    override fun onClick() {
        viewModel.imageViewClicked()
    }

    override fun onElementSelected(description: String, image: String) {
        viewModel.elementClicked(description, image)
    }

    companion object {

        internal val DATE = "date"
    }
}









