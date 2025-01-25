package com.example.zodiacmatchfinder.activities

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.zodiacmatchfinder.R
import java.text.DateFormat
import java.util.Calendar
import java.util.Date

class FindBYBirth : AppCompatActivity() {

    private lateinit var datePicker:DatePicker
    private lateinit var datePicker2:DatePicker
    private lateinit var imageView:ImageView
    private lateinit var imageView2:ImageView
    private lateinit var textViewImgC1: TextView
    private lateinit var textViewImgC2: TextView
    private lateinit var textViewvs: TextView
    private lateinit var textViewpersntage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_bybirth)
        datePicker=findViewById(R.id.datePiker)
        datePicker2=findViewById(R.id.datePiker2)
        textViewpersntage=findViewById(R.id.tvpercentage)
        textViewvs=findViewById(R.id.tvvs)
        textViewImgC1=findViewById(R.id.tvwithimg1)
        textViewImgC2=findViewById(R.id.tvwithimg2)
        imageView=findViewById(R.id.imgcland1)
        imageView2=findViewById(R.id.imgcland2)

        val button:Button=findViewById(R.id.BtncomB)
        button.setOnClickListener {
            compareDates()
            imageView.visibility = View.VISIBLE
            imageView2.visibility = View.VISIBLE

            Handler(mainLooper).postDelayed({
                imageView2.visibility = View.INVISIBLE
                imageView.visibility = View.INVISIBLE
            }, 3000)

        }
    }
    private val relationshipPercentages = ZodiacData.relationshipPercentages



    private fun compareDates() {


        val date1 = getSelectedDate(datePicker)
        val date2 = getSelectedDate(datePicker2)
        val zodiac1=getZodiacSign(date1)
        val zodiac=getZodiacSign(date2)
        when (zodiac1) {
            "Aries" -> imageView.setImageResource(R.drawable.ic_aries)
            "Taurus" -> imageView.setImageResource(R.drawable.ic_taurus)
            "Gemin" -> imageView.setImageResource(R.drawable.ic_gemini)
            "Cancer" -> imageView.setImageResource(R.drawable.ic_cancer)
            "Leo" -> imageView.setImageResource(R.drawable.ic_leo)
            "Virgo" -> imageView.setImageResource(R.drawable.ic_virgo)
            "Scorpio" -> imageView.setImageResource(R.drawable.ic_scropion)
            "Sagittarius" -> imageView.setImageResource(R.drawable.ic_sagittarius)
            "Capricorn" -> imageView.setImageResource(R.drawable.ic_capricorn)
            "Aquarius" -> imageView.setImageResource(R.drawable.ic_aquarius)
            "Pisces" -> imageView.setImageResource(R.drawable.ic_pisces)
            "libra" -> imageView.setImageResource(R.drawable.ic_libra)
            else->imageView.setImageResource(R.drawable.bcdefault)
        }
        when (zodiac) {
            "Aries" -> imageView2.setImageResource(R.drawable.ic_aries)
            "Taurus" -> imageView2.setImageResource(R.drawable.ic_taurus)
            "Gemin" -> imageView2.setImageResource(R.drawable.ic_gemini)
            "Cancer" -> imageView2.setImageResource(R.drawable.ic_cancer)
            "Leo" -> imageView2.setImageResource(R.drawable.ic_leo)
            "Virgo" -> imageView2.setImageResource(R.drawable.ic_virgo)
            "Scorpio" -> imageView2.setImageResource(R.drawable.ic_scropion)
            "Sagittarius" -> imageView2.setImageResource(R.drawable.ic_sagittarius)
            "Capricorn" -> imageView2.setImageResource(R.drawable.ic_capricorn)
            "Aquarius" -> imageView2.setImageResource(R.drawable.ic_aquarius)
            "Pisces" -> imageView2.setImageResource(R.drawable.ic_pisces)
            "libra" -> imageView2.setImageResource(R.drawable.ic_libra)
            else->imageView2.setImageResource(R.drawable.bcdefault)



        }
        val formattedDate1 = DateFormat.DATE_FIELD
        val formattedDate2 = DateFormat.DATE_FIELD

        val percentage = relationshipPercentages[zodiac1]?.get(zodiac) ?: 0

        textViewImgC1.setText(zodiac1)
        textViewImgC2.setText(zodiac)

        textViewpersntage.text = "$percentage%"

        val toastMessage = "Zodiacsign1:$zodiac1\nZodiacsign 2:$zodiac"
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
    }

    private fun getSelectedDate(datePicker: DatePicker): Date {
        val day = datePicker.dayOfMonth
        val month = datePicker.month
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.DAY_OF_MONTH, day)
        calendar.set(Calendar.MONTH, month)
        return calendar.time
    }

    private fun getZodiacSign(date: Date): String {
        val calendar = Calendar.getInstance()
        calendar.time = date
        val month = calendar.get(Calendar.MONTH) + 1
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        when {
            (month == 3 && day >= 21) || (month == 4 && day <= 19) -> return "Aries"
            (month == 4 && day >= 20) || (month == 5 && day <= 20) -> return "Taurus"
            (month == 5 && day >= 21) || (month == 6 && day <= 20) -> return "Gemini"
            (month == 6 && day >= 21) || (month == 7 && day <= 22) -> return "Cancer"
            (month == 7 && day >= 23) || (month == 8 && day <= 22) -> return "Leo"
            (month == 8 && day >= 23) || (month == 9 && day <= 22) -> return "Virgo"
            (month == 9 && day >= 23) || (month == 10 && day <= 22) -> return "Libra"
            (month == 10 && day >= 23) || (month == 11 && day <= 21) -> return "Scorpio"
            (month == 11 && day >= 22) || (month == 12 && day <= 21) -> return "Sagittarius"
            (month == 12 && day >= 22) || (month == 1 && day <= 19) -> return "Capricorn"
            (month == 1 && day >= 20) || (month == 2 && day <= 18) -> return "Aquarius"
            (month == 2 && day >= 19) || (month == 3 && day <= 20) -> return "Pisces"
            else -> return "Unknown"
        }
    }
}





