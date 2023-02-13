package com.example.clswrk_androidprojekt.presentation.view.home.items

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.database.Observable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.clswrk_androidprojekt.R
import com.example.clswrk_androidprojekt.databinding.FragmentSearchBinding
import com.example.clswrk_androidprojekt.presentation.view.auth.auth.LoginViewModel
import com.example.clswrk_androidprojekt.presentation.view.home.service.MusicPlayer
import com.example.clswrk_androidprojekt.utils.App
import com.example.clswrk_androidprojekt.utils.BaseFragment
import com.example.clswrk_androidprojekt.utils.rx.RxJavaExample
import com.squareup.picasso.Picasso
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.AsyncSubject
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.ReplaySubject
import javax.inject.Inject


class SearchFragment : BaseFragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding: FragmentSearchBinding get() = _binding!!



    private val viewModel: SeaechViewModel by viewModels{viewModelFactory}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // way1
        RxJavaExample().observableJust1()

        //way2
        RxJavaExample().observableJust2()

        //flatMap
        RxJavaExample().flatMapObservable()
        //zip
        RxJavaExample().zibObservable()


        //паблиш сабджект вызвал последние элементы на которые подписался
val publishSubject=PublishSubject.create<Int>()
        publishSubject.onNext(1)
        publishSubject.onNext(2)
        publishSubject.onNext(3)
        publishSubject.subscribe({Log.w("publish value1", it.toString())})
        publishSubject.onNext(5)
        publishSubject.onNext(6)
        publishSubject.subscribe({Log.w("publish value2", it.toString())})

            //реплей сабджект
        //все знач будут получены есмотря на то, что один подписался позже другого

        val replaySubject = ReplaySubject.create<Int>()
        replaySubject.onNext(1)
        replaySubject.onNext(2)
        replaySubject.onNext(3)
        replaySubject.subscribe({Log.w("Early1", it.toString())})
        replaySubject.onNext(5)
        replaySubject.onNext(6)
        replaySubject.subscribe({Log.w("Later2", it.toString())})


//бихевиор сабджект будет хранить ток полсдение знач


        val behaviorSubject = BehaviorSubject.create<Int>()
        behaviorSubject.onNext(1)
        behaviorSubject.onNext(2)
        behaviorSubject.onNext(3)
        behaviorSubject.subscribe({Log.w("Early1", it.toString())})
        behaviorSubject.onNext(4)
        behaviorSubject.subscribe({Log.w("Later2", it.toString())})
        behaviorSubject.onNext(5)
        behaviorSubject.onNext(6)



// не выдает данные до тех пор пока не завершится последовательность
        val asyncSubject = AsyncSubject.create<Int>()
        asyncSubject.onNext(1)
        asyncSubject.onNext(2)
        asyncSubject.onNext(3)
        asyncSubject.subscribe({Log.w("Early1", it.toString())})
        asyncSubject.onNext(4)
        asyncSubject.subscribe({Log.w("Later2", it.toString())})
        asyncSubject.onNext(5)
        asyncSubject.onNext(6)
        asyncSubject.onComplete()












        val devList = listOf<String>("IOS","Android","Flutter")

        io.reactivex.Observable.create<String>{
            emitter->
            devList.forEach { developer ->
                if(developer.isEmpty()){
                    emitter.onError(Exception("value is empty"))
                }
                emitter.onNext(developer)
            }
        }.doAfterNext{
            Log.w("next",it)
        }.doOnError {
        }.doOnComplete {
        Log.w("completed from created","finished")
        }.subscribe({}, {Log.w("erroe",it.message.toString())})



















        (requireActivity().applicationContext as App).provideAppComponent().inject(this)




        AnimationUtils.loadAnimation(binding.btStart.context, R.anim.rotate_anim).also {
            binding.btStart.startAnimation(it)
        }

        val animatorSet = AnimatorSet()

        val y = ObjectAnimator.ofFloat(binding.btStart, "scaleY", 2f, 1f)
        val x = ObjectAnimator.ofFloat(binding.btStart, "scaleX", 2f, 1f)
        animatorSet.playTogether(x, y)
        animatorSet.start()


//        val translate = ValueAnimator.ofFloat(2f,2f)
//        translate.addUpdateListener {  animation->
//            val scale = animation.animatedValue.toString().toFloat()
//            binding.btStop.SetscaleX(scale)
//            binding.btStop.SetscaleY(scale)
//        }


        binding.btStart.setOnClickListener {

            requireActivity().startForegroundService(
                Intent(
                    requireContext(),
                    MusicPlayer::class.java
                )
            )

        }

        binding.btStop.setOnClickListener {
            requireActivity().stopService(Intent(requireContext(), MusicPlayer::class.java))

        }



        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(q0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(q0: String?): Boolean {

                viewModel.findItem(q0 ?: "")

                return false

            }
        })
        viewModel.item.observe(viewLifecycleOwner) {
            binding.description.text = it.description
            Picasso.get().load(Uri.parse(it.image)).into(binding.image)
        }


    }
}


