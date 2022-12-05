package com.example.clswrk_androidprojekt.presentation.view

import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.presentation.adapter.ItemsAdapter
import com.example.clswrk_androidprojekt.model.ItemsModel


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clswrk_androidprojekt.data.ItemsRepositoryImpl
import com.example.clswrk_androidprojekt.databinding.FragmentItemsBinding
import com.example.clswrk_androidprojekt.databinding.FragmentOnBoardingBinding
import com.example.clswrk_androidprojekt.domain.ItemsInteractor
import com.example.clswrk_androidprojekt.presentation.adapter.listener.ItemsListener


class ItemsFragment : Fragment(), ItemsListener, ItemsView {

    private var _viewBinding: FragmentItemsBinding? = null
    private val viewBinding get()=_viewBinding!!

    private lateinit var itemsAdapter: ItemsAdapter

    lateinit var itemsPresenter: ItemsPresemter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _viewBinding = FragmentItemsBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        itemsPresenter = ItemsPresemter(this, ItemsInteractor(ItemsRepositoryImpl()))


        itemsAdapter = ItemsAdapter(this)


        // у фрагмента нет контекста. закрепляем как фрагмнт

     viewBinding.recyclerView.adapter = itemsAdapter

        itemsPresenter.getData()





    }

    override fun onClick() {
        itemsPresenter.imageViewClicked()

    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {

        itemsPresenter.elementSelected(name,date,imageView)


    }

    override fun dataReceived(list: List<ItemsModel>) {
        itemsAdapter.submitList(list)
    }

    override fun imageViewClicked(msg:Int) {
        Toast.makeText(context, getString(msg) , Toast.LENGTH_SHORT).show()

    }

    override fun goToDetails(name: String, date: String, imageView: Int) {
        val detailsFragment = DetailsFragment()
        // в бвндле храми маленькие данные и плюс можно там прописать ключик и имя ключика,
        // которые мы сможем передать в аргументы
        val bundle = Bundle()
        bundle.putString("name",name)
        bundle.putString("date",date)
        bundle.putInt("imageView",imageView)

        detailsFragment.arguments = bundle


        parentFragmentManager
            .beginTransaction()

            .replace(R.id.activity_container,detailsFragment)
            .addToBackStack("ded")
            .commit()
    }
}







