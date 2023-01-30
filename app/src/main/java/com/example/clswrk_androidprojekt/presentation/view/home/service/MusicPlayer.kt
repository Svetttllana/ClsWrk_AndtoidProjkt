package com.example.clswrk_androidprojekt.presentation.view.home.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import com.example.clswrk_androidprojekt.R


class MusicPlayer: Service() {


    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer.create(this, R.raw.melod)
        mediaPlayer.isLooping =true


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