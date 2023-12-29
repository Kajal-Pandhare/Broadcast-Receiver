package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyBr : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        mt(context,intent!!.action!!)

        if (intent!!.action!!.equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)){
            val isEnabled = intent!!.getBooleanExtra("state",false)
            mt(
                context,
                if (isEnabled) "Airplane mode is enabled" else "Airplane mode is disabled"
            )
        }
    }
    private fun mt(context: Context?,text : String){
        Toast.makeText(context!!,text,Toast.LENGTH_SHORT).show()
        Log.e("tag",text)
    }

}