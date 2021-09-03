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
                    finalString.text = resources.getString(R.string.incomplete_data)
                }

                else if (userAge.text.toString().toInt()<1 || userAge.text.toString().toInt()>100) {
                    finalString.text = resources.getString(R.string.invalid_age)
                }

                else {
                    val name: String = userName.text.toString()
                    var age: Int = (userAge.text.toString()).toInt()

                    if (age < 9 ) age *= 7
                    var finalNumber = age

                    while (finalNumber > 9 ){
                        finalNumber = finalNumber.toString().map(Character::getNumericValue).reduce{acc, num -> acc.toInt() + num.toInt() }
                        if(finalNumber < 10) finalNumber *= 7
                    }
                    finalString.text = resources.getString(R.string.welcome_message, name, finalNumber)

                    /* IMPLEMENTACION ORIGINAL
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
                    IMPLEMENTACION ORIGINAL */
                }
            }
    }
}