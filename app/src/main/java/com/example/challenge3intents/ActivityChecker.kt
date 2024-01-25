package com.example.challenge3intents

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class ActivityChecker : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checker)

        val textView: TextView = findViewById(R.id.textResults)
        val returnButton: Button = findViewById(R.id.buttonReturn)
        val intentText: String = intent.getStringExtra("text").toString()
        val intentTextLower = intentText.lowercase()
        val intentType: String? = intent.getStringExtra("type")
        var trueFalse = "is"
        val alphabet = "abcdefghijklmnopqrstuvwxyz"

        if(intentType == "Palindrome"){
            if(intentTextLower != intentTextLower.reversed()){
                trueFalse = "is not"
            }
            textView.setBackgroundColor(Color.parseColor("#61aaee"))
            textView.text = "${intentText} ${trueFalse} a palindrome."
        }else{
            val lowerstring = intentTextLower.map {it}
            if(!('a'..'z').all {lowerstring.contains(it)}){
                trueFalse = " is not"
            }
            textView.setBackgroundColor(Color.parseColor("#c00000"))
            textView.setTextColor(Color.WHITE)
            textView.text = "${intentText} ${trueFalse} a pangram."
        }

        returnButton.setOnClickListener(){
            val returnIntent = Intent(this, MainActivity::class.java)
            startActivity(returnIntent)
        }
    }
}