package com.example.zodiacmatchfinder.activities

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.zodiacmatchfinder.R
import com.example.zodiacmatchfinder.adapters.ZodiacAdapter
import com.example.zodiacmatchfinder.adapters.ZodiacItemClickListener

class FindBYStar : AppCompatActivity() {
    private lateinit var textView1: TextView
    private lateinit var textView2: TextView
    private lateinit var spinner1: Spinner
    private lateinit var spinner2: Spinner
    private lateinit var textViewimg1: TextView
    private lateinit var textViewimg2: TextView
    private lateinit var textVpercentagestr: TextView
    private lateinit var imageViewstr: ImageView
    private lateinit var imageViewstr2: ImageView
    var result="0"

    val zodiacSign = arrayOf(
        R.drawable.ic_aries,
        R.drawable.ic_taurus,
        R.drawable.ic_aquarius,
        R.drawable.ic_cancer,
        R.drawable.ic_capricorn,
        R.drawable.ic_gemini,
        R.drawable.ic_leo,
        R.drawable.ic_libra,
        R.drawable.ic_virgo,
        R.drawable.ic_sagittarius,
        R.drawable.ic_scropion,
        R.drawable.ic_pisces
    )
    val zodiacname = arrayOf(
        "Aries",
        "Taurus",
        "Gemini",
        "Cancer",
        "Leo",
        "Virgo",
        "Libra",
        "Scorpio",
        "Sagittarius",
        "Capricorn",
        "Aquarius",
        "Pisces"
    )
    lateinit var zodicadop: ZodiacAdapter
    lateinit var zodicadop2: ZodiacAdapter
    val dbHelper = DatabaseHandler(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_bystar)
        textView1 = findViewById(R.id.Tvstar1)
        textView2 = findViewById(R.id.Tvstar2)
        spinner1 = findViewById(R.id.spstar1)
        spinner2 = findViewById(R.id.spstar2)
        textViewimg1 = findViewById(R.id.tvwithImgStar1)
        textViewimg2 = findViewById(R.id.tvwithImgStar2)
        textVpercentagestr = findViewById(R.id.tvpercentageSTAR)
        var butttonmatch=findViewById<Button>(R.id.BtnComStar)

        imageViewstr = findViewById(R.id.imgstar1)
        imageViewstr2 = findViewById(R.id.imgStar2)

        var selectedSign1: String? = null
        var selectedSign2: String? = null
        butttonmatch.setOnClickListener{
            textVpercentagestr.text = "Compatibility: $result %"

        }

        zodicadop = ZodiacAdapter(this, zodiacSign, zodiacname, object : ZodiacItemClickListener {
            override fun onZodiacItemClick(position: Int) {
                selectedSign1 = zodiacname[position]
                textViewimg1.text = "Selected: $selectedSign1"
                imageViewstr.setImageResource(zodiacSign[position])
                updateCompatibility(selectedSign1, selectedSign2)
            }
        })
        spinner1.adapter = zodicadop

        zodicadop2 = ZodiacAdapter(this, zodiacSign, zodiacname, object : ZodiacItemClickListener {
            override fun onZodiacItemClick(position: Int) {
                selectedSign2 = zodiacname[position]
                textViewimg2.text = "Selected: $selectedSign2"
                imageViewstr2.setImageResource(zodiacSign[position])
                updateCompatibility(selectedSign1, selectedSign2)
            }
        })
        spinner2.adapter = zodicadop2
    }

    private fun updateCompatibility(sign1: String?, sign2: String?) {
        // Check if both zodiac signs are selected
        if (sign1 != null && sign2 != null) {
            // Retrieve compatibility value from the database
            val compatibilityValue = dbHelper.getCompatibilityValue(sign1, sign2)
            // Display the compatibility value
//            textVpercentagestr.text = "Compatibility: $compatibilityValue%"
            result=compatibilityValue.toString()
        }
    }
}
