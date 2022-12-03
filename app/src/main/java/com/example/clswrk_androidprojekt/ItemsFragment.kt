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
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clswrk_androidprojekt.ItemsViewModel


class ItemsFragment : Fragment(), ItemsListener {


    private lateinit var itemsAdapter: ItemsAdapter
    private val viewModel: ItemsViewModel by viewModels()

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

        viewModel.getData()
        viewModel.items.observe(viewLifecycleOwner) { listItems ->
            itemsAdapter.submitList(listItems)
        }
        viewModel.msg.observe(viewLifecycleOwner) { msg ->
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }
        viewModel.bundle.observe(viewLifecycleOwner) { navBundle ->

            val detailsFragment = DetailsFragment()
            // в бвндле храми маленькие данные и плюс можно там прописать ключик и имя ключика,
            // которые мы сможем передать в аргументы
            val bundle = Bundle()
            bundle.putString("name", navBundle.name)
            bundle.putString("date", navBundle.date)
            bundle.putInt("imageView", navBundle.image)

            detailsFragment.arguments = bundle


            parentFragmentManager
                .beginTransaction()
                .replace(R.id.activity_container, detailsFragment)
                .commit()

        }

    }


    override fun onClick() {
        viewModel.imageViewClicked()
    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {
        viewModel.elementClicked(name, date, imageView)
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





