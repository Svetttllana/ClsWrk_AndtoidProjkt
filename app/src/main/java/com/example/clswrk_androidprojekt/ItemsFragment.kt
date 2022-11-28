package com.example.clswrk_androidprojekt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clswrk_androidprojekt.adapter.ItemsAdapter
import com.example.clswrk_androidprojekt.listener.ItemsListener
import com.example.clswrk_androidprojekt.model.ItemsModel


class ItemsFragment : Fragment(), ItemsListener {


private lateinit var  itemsAdapter:ItemsAdapter




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_items, container, false)
    }
 override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
     super.onViewCreated(view, savedInstanceState)

     itemsAdapter = ItemsAdapter(this)



     val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
         // тхис во фрашменте мы анписать не можем  во вьюхах тоже можно прописать лайоут менеджер
     recyclerView.layoutManager = LinearLayoutManager(context)
recyclerView.adapter = itemsAdapter

     val listItems = listOf<ItemsModel>(
         ItemsModel(
             R.drawable.pineaple,
         "Android",
         "20.02.2001"

         ),
         ItemsModel(
             R.drawable.rose_image,
             "IOS",
             "19.02.2002"

         ),
         ItemsModel(
             R.drawable.memkit_image,
             "Flutter",
             "21.02.2001"

         ),
         ItemsModel(
             R.drawable.chmonya_image,
             "C++",
             "18.02.2001"

         ),
         ItemsModel(
             R.drawable.pineaple,
             "Phyton",
             "24.02.2001"

         ),
         ItemsModel(
             R.drawable.chmonya_image,
             ".NET",
             "29.02.2009"

         ),


     )

     itemsAdapter.submitList(listItems)



     }
    override fun onClick(){
        Toast.makeText(context," Image View" , Toast.LENGH_Short).show
    }
    override fun onElementSelected()
    val detailsFragment = DetailsFragment()
    val bundle = Bundle()






    bundle.putString("name",name)
    bundle.putString("date",date)
    bundle.putString("imageView",imageView)
    detailsFragment.arguments = bundle



    //TODO add метод мы больше не используем
    // теперь всегда используем replase
    //replace всегда будет иметь или аддТоБукстек, чтобы мы могли вернутся назад или же его не будет, чтобы мы вернулись назад
    parentFragmentManager.beginTrancation()



 }


