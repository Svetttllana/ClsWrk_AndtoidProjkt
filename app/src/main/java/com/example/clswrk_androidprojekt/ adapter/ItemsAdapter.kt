package com.example.clswrk_androidprojekt. adapter
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.listener.ItemsListener
import com.example.clswrk_androidprojekt.model.ItemsModel

class ItemsAdapter(
    private val itemsListener: ItemsListener
): RecyclerView.Adapter<ItemsViewHolder>() {




    //дист прватный виден ток в адапторе
    private var listItems = mutableListOf<ItemsModel>()
    // это метод по умолчанию и так его принято называть
        //инициализируем вот так
    fun submitList(list: List<ItemsModel>){
        this.listItems=list.toMutableList()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {

       val view= LayoutInflater.from(parent.context).inflate(R.layout.item_fruit,parent,false)
        return ItemsViewHolder(view,itemsListener)
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {

        holder.bind(listItems[position])
    }

    override fun getItemCount(): Int {
        return listItems.size
    }
}