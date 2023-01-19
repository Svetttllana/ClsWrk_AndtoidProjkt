package com.example.clswrk_androidprojekt.presentation.adapter

import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.presentation.listener.ItemsListener
import com.example.clswrk_androidprojekt.model.ItemsModel
import com.squareup.picasso.Picasso

class ItemsViewHolder(
    private var view: View,
    private var itemsListener: ItemsListener
) : RecyclerView.ViewHolder(view) {

    fun bind(itemsModel: ItemsModel) {

        val name = view.findViewById<TextView>(R.id.tv_name)
        val imageView = view.findViewById<ImageView>(R.id.iv_image)
//        val date = view.findViewById<TextView>(R.id.tv_date)

        name.text = itemsModel.description
        Picasso.get().load(Uri.parse(itemsModel.image)).into(imageView)



        imageView.setOnClickListener {
            itemsListener.onClick()
        }


        itemView.setOnClickListener {
            itemsListener.onElementSelected(
                itemsModel.description,
                itemsModel.image

            )

        }


    }

}