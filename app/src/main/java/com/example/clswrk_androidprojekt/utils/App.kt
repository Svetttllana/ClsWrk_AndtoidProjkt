package com.example.clswrk_androidprojekt.utils

import android.app.Application
import android.util.Log

import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import androidx.work.Configuration.Provider
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.clswrk_androidprojekt.data.worker.PeriodWorker
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import java.util.concurrent.TimeUnit

import javax.inject.Inject


//скоп эт область видимости
@HiltAndroidApp

class App:Application(),Configuration.Provider {

    @Inject lateinit var workFactory:HiltWorkerFactory
    val applicationScope = CoroutineScope(Dispatchers.Default)


    override fun getWorkManagerConfiguration(): Configuration {

        return Configuration.Builder()
            .setWorkerFactory(workFactory)
            .setMinimumLoggingLevel(Log.DEBUG)
            .build()


    }

    override fun onCreate() {
        super.onCreate()
        applicationScope.launch {
            createWorkManager()
        }
    }

    private fun createWorkManager(){
        val regestrationRequest = PeriodicWorkRequestBuilder<PeriodWorker>(15, TimeUnit.MINUTES).setInitialDelay(15,TimeUnit.MINUTES).build()
        WorkManager.getInstance(applicationContext).enqueueUniquePeriodicWork(
            PeriodWorker.WORKER_NAME,
            ExistingPeriodicWorkPolicy.KEEP,
            regestrationRequest
        )
    }




}
