package com.example.intent_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.intentvalid.R

class MoveActivityWithData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)
        val tvDataReceived: TextView =
            findViewById(R.id.tv_data_received)

        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getStringExtra(EXTRA_AGE)
        val add = intent.getStringExtra(EXTRA_ADD)
        val hp = intent.getStringExtra(EXTRA_HP)

        val text = "Name : $name, Your Age : $age, Your Address : $add, Your Phone Number : $hp"
        tvDataReceived.text = text
    }

    companion object {
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_ADD = "extra_add"
        const val EXTRA_HP = "extra_hp"
    }
}