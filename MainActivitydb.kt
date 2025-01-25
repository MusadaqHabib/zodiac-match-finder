/*
package com.example.zodiacmatchfinder.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.zodiacmatchfinder.R

class MainActivitydb : AppCompatActivity() {
    private lateinit var dataEditText:EditText
    private lateinit var dataEditmail:EditText

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activitydb)
        val buttoninsert=Button(findViewById(R.id.insertButton))
        val buttondalete=Button(findViewById(R.id.deleteButton))
        val buttonupdate=Button(findViewById(R.id.updateButton))
        val buttonretrive=Button(findViewById(R.id.retrieveButton))
        dataEditText=findViewById(R.id.name)
        dataEditmail=findViewById(R.id.dataEditEmail)
        var databaseHandler = DatabaseHandler(this)


        buttoninsert.setOnClickListener {
            var name=dataEditText.text.toString()
            var email=dataEditmail.text.toString()
            val id = databaseHandler.insertdata(name,email)
        }
        buttondalete.setOnClickListener {
                val id =34// get the id of the record you want to delete
                val result = databaseHandler.delete()

                if (result) {
                    Toast.makeText(this, "Data deleted successfully", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Failed to delete data", Toast.LENGTH_SHORT).show()

            }
            buttonupdate.setOnClickListener {
                val idToUpdate ="ali" // get the id of the record you want to update
                val newName = dataEditText.text.toString()
                val newEmail =dataEditmail.text.toString()
                val result = databaseHandler.updateUserData(idToUpdate, newName, newEmail)
                if (result) {
                    Toast.makeText(this, "Data updated successfully", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Failed to update data", Toast.LENGTH_SHORT).show()
                }
            }

        }


    }
}*/
