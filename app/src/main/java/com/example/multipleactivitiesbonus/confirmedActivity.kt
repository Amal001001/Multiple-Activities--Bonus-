package com.example.multipleactivitiesbonus

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class confirmedActivity : AppCompatActivity() {
    lateinit var rv:RecyclerView
    lateinit var adapter:Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmed)

        val info = intent.extras?.getStringArrayList("info")

        rv = findViewById(R.id.rv)
        adapter = Adapter(info)
        rv.adapter = Adapter(info)
        rv.layoutManager = LinearLayoutManager(this)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    @SuppressLint("RestrictedApi")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.home -> {
                val intent = Intent(this , MainActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.exit -> {
                    moveTaskToBack(true)
                    android.os.Process.killProcess(android.os.Process.myPid())
                    System.exit(1)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}