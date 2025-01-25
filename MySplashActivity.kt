package com.example.zodiacmatchfinder.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.zodiacmatchfinder.R

class MySplashActivity : AppCompatActivity()
{ private val SPLASH_TIME_OUT: Long = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val textView:TextView= findViewById(R.id.Txtsplash)
        Handler().postDelayed({

            val intent = Intent(this,WellcomActivity::class.java)
            startActivity(intent)
            // Close this activity
            finish()
        }, SPLASH_TIME_OUT)


    }
}