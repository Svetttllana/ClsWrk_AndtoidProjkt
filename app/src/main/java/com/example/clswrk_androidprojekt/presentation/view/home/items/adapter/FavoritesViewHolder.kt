package com.example.clswrk_androidprojekt.presentation.view.home.items.adapter

import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clswrk_androidprojekt.R

import com.example.clswrk_androidprojekt.domain.model.FavoriteModel
import com.squareup.picasso.Picasso


class FavoritesViewHolder(
    private var view: View

    ) : RecyclerView.ViewHolder(view) {

    fun bind(favItems: FavoriteModel) {
        val imageView = view.findViewById<ImageView>(R.id.iv_image)
        val name = view.findViewById<TextView>(R.id.tv_name)

        name.text = favItems.description
        Picasso.get().load(Uri.parse(favItems.image)).into(imageView)


    }

}