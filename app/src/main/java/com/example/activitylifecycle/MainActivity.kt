package com.example.activitylifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

const val EXTRA_MESSAGE = "com.example.activitylifecycle.MESSAGE"

class MainActivity : AppCompatActivity() {

    private val etPhoneNumber: EditText by lazy { findViewById(R.id.etPhoneNumber) }
    private val btnSendPhoneNumber: Button by lazy { findViewById(R.id.btnSendPhoneNumber) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSendPhoneNumber.setOnClickListener {
            sendMessage()
        }
    }

    fun sendMessage() {
        val message = etPhoneNumber.text.toString()
        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }
}