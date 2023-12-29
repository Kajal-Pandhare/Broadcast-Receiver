package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class NewBr : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(
            context!!,
            "${intent!!.action} --${intent.getStringExtra("path")}",
            Toast.LENGTH_LONG
        ).show()
    }

}