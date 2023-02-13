package com.example.clswrk_androidprojekt.utils.rx

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RxJavaExample {

    //1 способ
    fun observableJust1() {
        val davelopers: io.reactivex.Observable<String> = io.reactivex.Observable.just(
            "IOS",
            "Android",
            "flutter"
        )
        davelopers.doAfterNext {
            Log.w("next", it)
        }.doOnError {

        }.doOnComplete {
            Log.w("completed", "finish")
        }.subscribe()
    }


    fun observableJust2() {

        //2 способ
        val davelopersAnotherWay: io.reactivex.Observable<String> = io.reactivex.Observable.just(
            "IOS",
            "Android",
            "flutter"
        )

        davelopersAnotherWay.subscribe({
            Log.w("next", it)
        }, {
            //here error thrown
        }, {
            Log.w("completed", "finish")
        }
        )
    }

    fun concatObservable() {
        val devs = io.reactivex.Observable.just("IOS", "Android", "Flutter")
        val langs = io.reactivex.Observable.just("Svift", "Kotlin", "Dart")
        val comps = io.reactivex.Observable.just("Apple", "Google")

        io.reactivex.Observable.concat(devs, langs, comps)
            .subscribe { Log.w("result concat", it.toString()) }
    }

    fun zibObservable() { //zip обьединяет значения для каждого обсервабла в один
        io.reactivex.Observable.zip(
            io.reactivex.Observable.just("IOS", "Android", "Flutter"),
            io.reactivex.Observable.just("Svift", "Kotlin", "Dart")
        ) { dev, lang ->
            "$dev writes in $lang"
        }.subscribe({ Log.w("result zip", it) })
    }

    fun flatMapObservable() {
        io.reactivex.Observable.just("IOS", "Android", "Flutter")
            .subscribeOn(Schedulers.io())
            .flatMap {
                io.reactivex.Observable.just("$it 2")
                    .subscribeOn(Schedulers.io())
            }.observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.w("result", it.toString())
            }

    }
}