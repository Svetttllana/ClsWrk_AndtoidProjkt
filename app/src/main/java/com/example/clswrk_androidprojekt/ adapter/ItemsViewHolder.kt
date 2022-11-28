package com.example.clswrk_androidprojekt.`adapter`

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.listener.ItemsListener
import com.example.clswrk_androidprojekt.model.ItemsModel

class ItemsViewHolder(private val view: View,
private val itemsListener: ItemsListener
                      ):RecyclerView.ViewHolder(view) {

    // во вьюхолдере всегда баинд и сабмитлист
    fun bind(string: String){

        val name = view.findViewById<TextView>(R.id.tv_pinaple)
        val imageView = view.findViewById<ImageView>(R.id.)
        val date = view.findViewById<ImageView>(R.id.)

//        name.text = string
//imageView.setBackgroundResource(itemsModel.)
//        date.text = itemsModel.date


        imageView.setOnClickListener {

            itemsListener.onClick()
        }

        itemView.setOnClickListener{
            itemsListener.onElementSelected(
                itemsModel.name,itemsModel.date,itemsModel.image
            )

        }



    }

}