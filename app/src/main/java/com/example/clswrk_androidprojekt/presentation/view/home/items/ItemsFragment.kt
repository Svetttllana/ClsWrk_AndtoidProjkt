package com.example.clswrk_androidprojekt.presentation.view.home.items


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.presentation.adapter.ItemsAdapter
import com.example.clswrk_androidprojekt.presentation.listener.ItemsListener
import com.example.clswrk_androidprojekt.presentation.view.auth.auth.LoginViewModel
import com.example.clswrk_androidprojekt.utils.App
import com.example.clswrk_androidprojekt.utils.BaseFragment
import com.example.clswrk_androidprojekt.utils.BundleConstans.IMAGE_VIEW
import com.example.clswrk_androidprojekt.utils.navigateWithBandl
import javax.inject.Inject


class ItemsFragment : BaseFragment(), ItemsListener {


    private lateinit var itemsAdapter: ItemsAdapter


    private val viewModel: ItemsViewModel by viewModels{viewModelFactory}


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().applicationContext as App).provideAppComponent().inject(this)

        itemsAdapter = ItemsAdapter(this)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = itemsAdapter



        //sposob1
//        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
//            viewModel.getData.collect()
//        }

        //sposob2
//        viewModel.getData()
//        viewModel.trigger.observe(viewLifecycleOwner){
//            viewLifecycleOwner.lifecycleScope.launchWhenResumed {
//                it.collect()
//            }
//        }

//        //sposob3
//        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
//            viewModel.getDataSimple()
//        }


viewModel.getData()

      viewModel.items.observe(viewLifecycleOwner){
          itemsAdapter.submitList(it)
      }

//        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
//            viewModel.items.collect{flowList->
//                flowList.collect{list ->
//                    itemsAdapter.submitList(list)
//            }
//            }
//        }

        viewModel.msg.observe(viewLifecycleOwner) { msg ->
            Toast.makeText(context, getString(msg), Toast.LENGTH_SHORT).show()
            Log.w("str", getString(msg))
        }
        viewModel.bundle.observe(viewLifecycleOwner) { navBundle ->
            if (navBundle != null) {
                val bundle = Bundle()
                bundle.putString("description", navBundle.description)
                bundle.putString(IMAGE_VIEW, navBundle.image)


                navigateWithBandl(
                    navBundle.destinationiD,
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

    override fun onDeliteClicked(description: String) {
        viewModel.deliteItem(description)
    }

    override fun onFavClicked(description: String,isFavorite:Boolean) {
        viewModel.onFavClicked(description, isFavorite )
    }


}









