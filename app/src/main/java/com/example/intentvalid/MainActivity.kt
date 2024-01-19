package com.example.intent_app

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import com.example.intentvalid.R

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveWithData: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithData.setOnClickListener(this)

        val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)


    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_activity_data -> {

                val nameEditText = findViewById<EditText>(R.id.data_nama)
                val ageEditText = findViewById<EditText>(R.id.data_age)
                val addressEditText = findViewById<EditText>(R.id.data_address)
                val phoneNumberEditText = findViewById<EditText>(R.id.phoneNumber)

                val name = nameEditText.text.toString()
                val age = ageEditText.text.toString()
                val address = addressEditText.text.toString()
                val phoneNumber = phoneNumberEditText.text.toString()

                val moveActivityWithData =
                    Intent(this@MainActivity, MoveActivityWithData::class.java)
                moveActivityWithData.putExtra(
                    MoveActivityWithData.EXTRA_NAME, name
                )

                moveActivityWithData.putExtra(
                    MoveActivityWithData.EXTRA_AGE, age
                )

                moveActivityWithData.putExtra(
                    MoveActivityWithData.EXTRA_ADD, address
                )
                moveActivityWithData.putExtra(
                    MoveActivityWithData.EXTRA_HP, phoneNumber
                )
                startActivity(moveActivityWithData)
            }

            R.id.btn_dial_number -> {
                val phoneNumberEditText = findViewById<EditText>(R.id.phoneNumber)
                val phoneNumber = phoneNumberEditText.text.toString()

                val dialPhoneIntent = Intent(
                    Intent.ACTION_DIAL,
                    Uri.parse("tel:${phoneNumber}")
                )
                startActivity(dialPhoneIntent)
            }


        }
    }
}