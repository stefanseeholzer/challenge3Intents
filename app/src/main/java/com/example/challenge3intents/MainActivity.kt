package com.example.challenge3intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textInput: EditText = findViewById(R.id.editTextInput)
        val palindromeButton: Button = findViewById(R.id.buttonPalindrome)
        val pangramButton: Button = findViewById(R.id.buttonPangram)

        palindromeButton.setOnClickListener(){
            checker("Palindrome", textInput)
        }

        pangramButton.setOnClickListener(){
            checker("Pangram", textInput)
        }
    }

    private fun checker(type: String, textInput: EditText){
        if(textInput.text.toString().length < 3){
            textInput.text.clear()
            textInput.hint = "Enter a word/phrase greater than 2 characters"
        }else {
            val palindromeIntent = Intent(this@MainActivity, ActivityChecker::class.java)
            palindromeIntent.putExtra("text", textInput.text.toString())
            palindromeIntent.putExtra("type", type)
            startActivity(palindromeIntent)
        }
    }
}