package com.example.clswrk_androidprojekt.utils

import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*

//посмотри шо распечатает в логах
// имя корутины можно выводить если она падает или вылетает какая-то ошибка

class CoroutinesExample {
    fun testCoroutineJoin() {
        CoroutineScope(Dispatchers.IO).launch {
            val job = launch {
                for (i in 1..5) {
                    Log.w("called", "$i")
                    delay(400)
                }
            }
            Log.w("start", "Started")
            job.join()
            Log.w("finish", "Finished")

        }
    }

    fun testCoroutineCancel() {
        CoroutineScope(CoroutineName("TMS less 28")+(Dispatchers.IO)).launch {
            val job = launch {
                for (i in 1..5) {
                    Log.w("called", "$i")
                    delay(400)
                }
            }
            Log.w("start", "Started")
            job.cancel()
            Log.w("finish", "${coroutineContext[CoroutineName.Key]}")

        }
    }
}