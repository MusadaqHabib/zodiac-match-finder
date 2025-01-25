package com.example.zodiacmatchfinder.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.zodiacmatchfinder.R

class ZodiacAdapter(
    context: Context,
    private val zodiacsign: Array<Int>,
    private val zodiacname: Array<String>,
    private val clickListener: ZodiacItemClickListener
) :
    ArrayAdapter<String>(context, R.layout.item_zodiac, zodiacname) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createView(position, convertView, parent)
    }

    fun createView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(context)
        val view = convertView ?: inflater.inflate(R.layout.item_zodiac, parent, false)
        val imageView: ImageView = view.findViewById(R.id.zodicimageview)
        val textView: TextView = view.findViewById(R.id.zodictextview)
        imageView.setImageResource(zodiacsign[position])
        textView.text = zodiacname[position]
        view.setOnClickListener {
            clickListener.onZodiacItemClick(position)
        }

        return view
    }
}

interface ZodiacItemClickListener {
    fun onZodiacItemClick(position: Int)
}