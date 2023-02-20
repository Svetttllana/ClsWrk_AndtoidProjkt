package com.example.clswrk_androidprojekt.presentation.reseiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast


class MyBroadcastReceiver : BroadcastReceiver() {

        override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == "MY_ACTION") {
            Toast.makeText(
                context,
                "MY ACTION CALLED ${intent.getStringExtra("KEY")}",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
