package com.serrano.ejemplo04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {



    lateinit var mEmailEditText : EditText
    lateinit var mMessageEditText : EditText
    lateinit var mContactButton : Button

    val TAG: String = MainActivity::class.qualifiedName.toString()

    companion object{
        val EMAIL_KEY = "text_email"
        val MESSAGE_KEY = "text_message"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindView()


        mContactButton.setOnClickListener{
            val message = mMessageEditText.text.toString()
            val email = mEmailEditText.text.toString()


           // Log.d("${TAG}.email", email)
            // Log.d("${TAG}.message", message)
        }
    }

    private fun bindView (){
        mEmailEditText = findViewById(R.id.et_email)
        mMessageEditText = findViewById(R.id.et_message)
        mContactButton = findViewById(R.id.bt_contact)

    }

    fun addEventListener(){
        //contactar

        mContactButton.setOnClickListener{
            var emailText : String = mEmailEditText.text.toString()
            var messageText : String = mMessageEditText.text.toString()

            Log.d(TAG, "$emailText --- $messageText")

            var intent = intent(this, SecondActivity::class.java)
            intent.putExtra(MainActivity.EMAIL_KEY,emailText)
            intent.putExtra(MainActivity.MESSAGE_KEY, messageText)
            startActivity(intent)
        }
    }
}
