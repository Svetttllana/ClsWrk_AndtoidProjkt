package com.example.clswrk_androidprojekt.adapter



import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.listener.ItemsListener
import com.example.clswrk_androidprojekt.model.ItemsModel
// должен показать данные из листа на ю-ай.
// он получчает 1 элемент из всего списка и ему присваивает вьюшки
class ItemsViewHolder(
    private var view: View,
    private var itemsListener: ItemsListener
) : RecyclerView.ViewHolder(view) {

    // во вьюхолдере всегда баинд и сабмитлист
    fun bind(itemsModel: ItemsModel) {


        val name = view.findViewById<TextView>(R.id.tv_name)
        val imageView = view.findViewById<ImageView>(R.id.iv_image)
        val date = view.findViewById<TextView>(R.id.tv_date)

        name.text = itemsModel.name
        imageView.setBackgroundResource(itemsModel.image)
        date.text = itemsModel.date


        imageView.setOnClickListener {

            itemsListener.onClick()
        }


        //получаем данные того элемента на который нажали,
        // вьюХолдер работает по позициям
        itemView.setOnClickListener {
            itemsListener.onElementSelected(
                itemsModel.name, itemsModel.date, itemsModel.image
            )

        }


    }

}