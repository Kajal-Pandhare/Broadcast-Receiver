package com.example.broadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.broadcastreceiver.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myBr: MyBr
    private lateinit var newBr: NewBr

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val filters = IntentFilter(Intent.ACTION_WALLPAPER_CHANGED)
        filters.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        filters.addAction(Intent.ACTION_BATTERY_LOW)
        filters.priority = 1000

        myBr = MyBr()
        registerReceiver(myBr,filters)

        binding.btnRegister.setOnClickListener {
            newBr = NewBr()
            val filters = IntentFilter("in.bitcode.download.COMPLETE")
            registerReceiver(newBr,filters, RECEIVER_EXPORTED)

        }
        binding.btnUnRegister.setOnClickListener {
            unregisterReceiver(newBr)
        }
        binding.btnSendBroadcast.setOnClickListener {
            val intent = Intent()
            intent.action = "in.bitcode.download.COMPLETE"
            intent.putExtra("path",binding.edtTextPath.text.toString())

            sendStickyBroadcast(intent)
        }
    }

    override fun onDestroy() {
        unregisterReceiver(myBr)
        super.onDestroy()
    }
}