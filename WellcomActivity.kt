package com.example.zodiacmatchfinder.activities

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.zodiacmatchfinder.R


class WellcomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wellcom)
         val buttonRateus:Button=findViewById(R.id.rateus)
        val buttonMORE:Button=findViewById(R.id.findmore)
        val appCompatButton1:Button = findViewById(R.id.find)
        val appCompatbutton:Button=findViewById(R.id.findstar)
        appCompatButton1.setOnClickListener {
            val intent =Intent(this@WellcomActivity, FindBYBirth::class.java)
            startActivity(intent)
        }
     appCompatbutton.setOnClickListener {
            val intent =Intent(this@WellcomActivity,FindBYStar::class.java)
            startActivity(intent)
        }
        buttonRateus.setOnClickListener {
            try {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("market://details?id=$packageName")
                    )
                )
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
                    )
                )
            }

        }
        buttonMORE.setOnClickListener {
            val developerName = "soulations of techonolgy"
            try {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("market://search?q=pub:$developerName")
                    )
                )
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=$developerName")
                    )
                )
            }
        }

    }
}
