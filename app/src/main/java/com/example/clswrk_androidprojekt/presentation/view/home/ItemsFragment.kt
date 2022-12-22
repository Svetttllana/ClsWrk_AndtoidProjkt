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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clswrk_androidprojekt.*
import com.example.clswrk_androidprojekt.databinding.FragmentHomeBinding
import com.example.clswrk_androidprojekt.databinding.FragmentItemsBinding
import com.example.clswrk_androidprojekt.model.ItemsModel
import com.example.clswrk_androidprojekt.presentation.adapter.ItemsAdapter
import com.example.clswrk_androidprojekt.utils.BundleConstans.DATE
import com.example.clswrk_androidprojekt.utils.BundleConstans.IMAGE_VIEW
import com.example.clswrk_androidprojekt.utils.BundleConstans.NAME
import com.example.clswrk_androidprojekt.utils.NavigationExt.fmReplace
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class ItemsFragment : Fragment(), ItemsListener, ItemsView {

    private var _binding: FragmentItemsBinding? = null
    private val binding: FragmentItemsBinding get() = _binding!!

    private lateinit var itemsAdapter: ItemsAdapter


    @Inject
    lateinit var itemsPresenter: ItemsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentItemsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsPresenter.setview(this)

        itemsAdapter = ItemsAdapter(this)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = itemsAdapter

        itemsPresenter.getItems()


    }


    override fun onClick() {
        itemsPresenter.imageViewClicked()
    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {
        itemsPresenter.itemClicked(name, date, imageView)


    }

    override fun ItemasReceived(itemsList: List<ItemsModel>) {
        itemsAdapter.submitList(itemsList)
    }

    override fun imageViewClicked(msg: Int) {
        Toast.makeText(context, getString(msg), Toast.LENGTH_SHORT).show()
    }


    override fun itemClick(navigationData: NavigateWithBundle) {
        val detailsFragment = DetailsFragment()
        val bundle = Bundle()
        bundle.putString(NAME, navigationData.name)
        bundle.putString(DATE, navigationData.date)
        bundle.putInt(IMAGE_VIEW, navigationData.image)
        detailsFragment.arguments = bundle

        fmReplace(parentFragmentManager, detailsFragment, true)
    }


}









