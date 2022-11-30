import com.example.clswrk_androidprojekt.DetailsFragment
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.adapter.ItemsAdapter
import com.example.clswrk_androidprojekt.listener.ItemsListener
import com.example.clswrk_androidprojekt.model.ItemsModel


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class ItemsFragment : Fragment(), ItemsListener {


    private lateinit var itemsAdapter: ItemsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsAdapter = ItemsAdapter(this)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        // у фрагмента нет контекста. закрепляем как фрагмнт
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = itemsAdapter


        val listItems = listOf<ItemsModel>(
            ItemsModel(R.drawable.banana, "Android", "20.20.2020"),
            ItemsModel(R.drawable.apple, " IOS,", "10.10.2020"),
            ItemsModel(R.drawable.rofl_kit3, "Flutter", "19.20.2022"),
            ItemsModel(R.drawable.rofl, "Python", "20.10.2023"),
            ItemsModel(R.drawable.apple, "Xamarin", "02.04.2024"),
            ItemsModel(R.drawable.banana, ".NET", "20.20.2020"),
            ItemsModel(R.drawable.rose_image, "C++", "06.05.2020"),
            ItemsModel(R.drawable.rofl_kit3, "C", "07.10.2020"),
            ItemsModel(R.drawable.rofl_kit2, "PHP", "20.06.2020"),
            ItemsModel(R.drawable.chmonya_image, "Ruby on Rails", "20.06.2020"),
            ItemsModel(R.drawable.rofl, "JS", "20.06.2020"),
            ItemsModel(R.drawable.mem_kit_ofise, "apple", "20.06.2020"),
            ItemsModel(R.drawable.mem_kit_image, "pineaple", "20.06.2020")

        )
        itemsAdapter.submitList(listItems.toList())


    }

    override fun onClick() {
        Toast.makeText(context, "ImageView clicked" , Toast.LENGTH_SHORT).show()
    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {
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
            .add(R.id.activity_container,detailsFragment)
                       .commit()
    }
}


//        //TODO add метод мы больше не используем
//        // теперь всегда используем replase
//        //replace всегда будет иметь или аддТоБукстек, чтобы мы могли вернутся назад или же его не будет,
//        // чтобы мы вернулись назад
//        parentFragmentManager.beginTransaction()
//            .replace(R.id.activity_container,detailsFragment)
//            .addToBackStack("Details")
//            .commit()





