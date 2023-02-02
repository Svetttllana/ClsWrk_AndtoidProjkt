package com.example.clswrk_androidprojekt.presentation.view.home.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Color.RED
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.example.clswrk_androidprojekt.R


class MusicPlayer: Service() {


    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate() {
        super.onCreate()
        startForeground()
        mediaPlayer = MediaPlayer.create(this, R.raw.melod)
        mediaPlayer.isLooping =true

    }
    //раньше нотификации не использовали ченел ай ди. до 8 версии все нотификации должны юзать ченел ай ди.
    private fun startForeground(){
        val chanelId = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            creeteNotificationChanel()
        }else{
         //If earlier version chanel IO is not used
            ""
        }
        val notificationBuilder=NotificationCompat.Builder(this,chanelId)
        val notification = notificationBuilder.setOngoing(true)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setColor(RED)
            .setContentTitle("NOTIFICATION")
            .setCategory(Notification.CATEGORY_SERVICE)
            .build()
            startForeground(101,notification)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun creeteNotificationChanel():String{
        val chanelId = "MY_Service"
        val chanelName = " MY Foreground Service"
        val chan = NotificationChannel(chanelId,chanelName,NotificationManager.IMPORTANCE_HIGH)
        chan.lightColor= Color.BLUE
        chan.importance = NotificationManager.IMPORTANCE_NONE
//chan.lockscreenVisibility = NotificationManager.

        val service = getSystemService(Context.NOTIFICATION_SERVICE)as NotificationManager
        service.createNotificationChannel(chan)
        return chanelId
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mediaPlayer.start()
        return super.onStartCommand(intent, flags, startId)

    }


    override fun onBind(intent: Intent?): IBinder? {
        return null

    }

    override fun onDestroy() {
        mediaPlayer.stop()
        super.onDestroy()

    }


}