package com.example.alienware.kanggame

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_first.*


class First : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        textView.setOnClickListener {
            val intent = Intent(this,Second::class.java)
            startActivity(intent)
        }

    }

}
