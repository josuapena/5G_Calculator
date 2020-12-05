package com.jptechnology.appestacaohack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Open loginActivity after 5 sec
        Handler(Looper.getMainLooper()).postDelayed({
            // Start intent
            val mIntent = Intent(this, RecepcaoActivity::class.java)
            startActivity(mIntent)
            finish()
        }, 5000)
    }
}