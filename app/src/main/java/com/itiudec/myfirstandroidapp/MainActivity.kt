package com.itiudec.myfirstandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userName = findViewById<EditText>(R.id.userName) // val a
        val userAge = findViewById<EditText>(R.id.userAge) // val b

        val finalString = findViewById<TextView>(R.id.finalString)

        val mainButton = findViewById<Button>(R.id.mainButton)
            .setOnClickListener() {

                if (userAge.text.isEmpty() || userName.text.isEmpty()) {
                    finalString.text = "Please enter the required data"
                }

                else if (userAge.text.toString().toInt()<1) {
                    finalString.text = "Please enter a valid age"
                }

                else {
                    val name: String = userName.text.toString()
                    var age: Int = (userAge.text.toString()).toInt()
                    var age1 = age
                    var finalNumber = 0
                    var luckNumber = 0

                    while(luckNumber == 0 || luckNumber >10){
                        age1 = age % 10
                        age /= 10
                        finalNumber += age1

                        if(age==0){
                            luckNumber = finalNumber * 7
                        }
                    }

                    finalString.text = "Welcome $name the Universe dictates to keep the following number close to you: $luckNumber"

                }
            }
    }
}