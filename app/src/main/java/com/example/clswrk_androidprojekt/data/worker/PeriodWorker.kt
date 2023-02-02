package com.example.clswrk_androidprojekt.data.worker

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.clswrk_androidprojekt.data.items.ItemsRepositoryImpl
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltWorker
class PeriodWorker @AssistedInject constructor(
    @Assisted  val context: Context,
    @Assisted parameters: WorkerParameters,
    val itemsRepositoryImpl:ItemsRepositoryImpl
):CoroutineWorker(context,parameters) {



    override suspend fun doWork(): Result {

    try {
        CoroutineScope(Dispatchers.IO).launch {
            Log.w("Do Work called", "get data")
itemsRepositoryImpl.getData()
        }

        }  catch (e:Exception){
        Log.w("Do Work called", "get data")
    return  Result.retry()
    }

   return Result.success()
      }

    companion object {
        const val WORKER_NAME = "Worker Name"
    }

}






