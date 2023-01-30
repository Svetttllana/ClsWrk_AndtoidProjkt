package com.example.clswrk_androidprojekt.presentation.view.home.items.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.domain.model.FavoriteModel
import com.example.clswrk_androidprojekt.domain.model.ItemsModel

class FavoritesAdapter() : RecyclerView.Adapter<FavoritesViewHolder>() {
    private var listItems = mutableListOf<FavoriteModel>()

    fun submitList(list: List<FavoriteModel>) {
        this.listItems.clear()
        this.listItems = list.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_favorites, parent, false)
        return FavoritesViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        holder.bind(listItems[position])
    }

    override fun getItemCount(): Int {
        return listItems.size
    }
}