package com.example.multipleactivitiesbonus

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var name: EditText
    lateinit var location: EditText
    lateinit var phone: EditText
    lateinit var email: EditText
    lateinit var cb: CheckBox
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.name)
        location = findViewById(R.id.location)
        phone = findViewById(R.id.phone)
        email = findViewById(R.id.email)
        cb = findViewById(R.id.checkBox)

        button = findViewById(R.id.button)
        button.setOnClickListener {
            if(name.text.toString() != "" && location.text.toString() != "" && phone.text.toString() != "" && email.text.toString() != "") {
                if (cb.isChecked) {
                    val intent = Intent(this, confirmationActivity::class.java)
                    intent.putExtra("name", name.text.toString())
                    intent.putExtra("location", location.text.toString())
                    intent.putExtra("phone", phone.text.toString())
                    intent.putExtra("email", email.text.toString())
                    startActivity(intent)
                } else {
                    val dialogBuilder = AlertDialog.Builder(this)
                    dialogBuilder.setMessage("please check the box")
                        .setPositiveButton("OK", DialogInterface.OnClickListener { _, _ ->
                        })
                    val alert = dialogBuilder.create()
                    alert.show()
                }
            }else{
                Toast.makeText(this, "All fields must be filled", Toast.LENGTH_LONG).show()
            }
        }

    }
}