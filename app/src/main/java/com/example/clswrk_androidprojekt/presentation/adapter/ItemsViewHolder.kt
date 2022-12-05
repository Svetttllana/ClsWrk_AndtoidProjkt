package com.example.clswrk_androidprojekt.presentation.adapter
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.databinding.ItemFruitBinding
import com.example.clswrk_androidprojekt.model.ItemsModel
import com.example.clswrk_androidprojekt.presentation.adapter.listener.ItemsListener

// должен показать данные из листа на ю-ай.
// он получчает 1 элемент из всего списка и ему присваивает вьюшки

class ItemsViewHolder(
    private var viewBinding: ItemFruitBinding,
    private var itemsListener: ItemsListener
) : RecyclerView.ViewHolder(viewBinding.root) {

    // во вьюхолдере всегда баинд и сабмитлист
    fun bind(itemsModel: ItemsModel) {


     viewBinding.tvName.text = itemsModel.name
     viewBinding.ivImage.setBackgroundResource(itemsModel.image)
     viewBinding.tvDate.text = itemsModel.date



       viewBinding.ivImage.setOnClickListener {

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