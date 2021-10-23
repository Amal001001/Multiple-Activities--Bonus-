package com.example.multipleactivitiesbonus

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class confirmationActivity : AppCompatActivity() {
    lateinit var tv :TextView
    lateinit var button2: Button
    lateinit var info:ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        info = arrayListOf()

        tv = findViewById(R.id.tv)
        val name = intent.getStringExtra("name").toString()
        val location = intent.getStringExtra("location").toString()
        val phone = intent.getStringExtra("phone").toString()
        val email = intent.getStringExtra("email").toString()
        var infoText = "Name : ${name}\nlocation: ${location} \nphone: ${phone} \nemail: ${email}"
        tv.text = infoText

        button2 = findViewById(R.id.button2)
        button2.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this)
            val tvAlert = TextView(this)
            tvAlert.text = infoText

            dialogBuilder.setMessage("Are you sure?")
                .setPositiveButton("yes", DialogInterface.OnClickListener { _, _ ->
                    val intent = Intent(this , confirmedActivity::class.java)
                    info.add(name)
                    info.add(location)
                    info.add(phone)
                    info.add(email)
                    intent.putExtra("info", info)
//                    intent.putExtra("name", name)
//                    intent.putExtra("location", location)
//                    intent.putExtra("phone", phone)
//                    intent.putExtra("email", email)
                    startActivity(intent)
                })

            val alert = dialogBuilder.create()
            alert.setView(tvAlert)
            alert.show()
        }
    }
}