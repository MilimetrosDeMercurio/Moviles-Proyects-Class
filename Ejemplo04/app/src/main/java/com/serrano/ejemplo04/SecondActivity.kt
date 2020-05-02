package com.serrano.ejemplo04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private val TAG : String = SecondActivity::class.qualifiedName.toString()

    lateinit var mDisplayEmailTextView : TextView
    lateinit var mDisplayMessageTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        if(intent != null){
           val emailText = intent.getStringExtra(MainActivity.EMAIL_KEY)
            val messageText = intent.getStringExtra(MainActivity.MESSAGE_KEY)

            mDisplayMessageTextView.text = messageText
            mDisplayEmailTextView.text = emailText

        }
    }

    fun bindView(){

        mDisplayEmailTextView = findViewById(R.id.et_email)
        mDisplayMessageTextView = findViewById(R.id.et_message)

    }
}
