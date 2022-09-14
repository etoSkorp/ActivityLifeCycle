package com.example.activitylifecycle

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private val tvPhoneNumber: TextView by lazy { findViewById(R.id.tvPhoneNumber) }
    private val btnCall: Button by lazy { findViewById(R.id.btnCall) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val message = intent.getStringExtra(EXTRA_MESSAGE)
        tvPhoneNumber.text = message

        btnCall.setOnClickListener {
            phoneCall()
        }
    }

    private fun phoneCall() {
        val intent = Intent (Intent.ACTION_CALL)
        intent.data = Uri.parse("tel: ${tvPhoneNumber.text}")
        startActivity (intent)
    }

}