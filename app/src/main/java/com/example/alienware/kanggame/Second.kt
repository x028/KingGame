package com.example.alienware.kanggame

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_second.*

class Second : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val sharedPrefrences = PreferenceManager.getDefaultSharedPreferences(this)
        val sharedPreferencesEditor = sharedPrefrences.edit()
        startMatchBtu.setOnClickListener {

            sharedPreferencesEditor.putString("FIRSTTEAM", firstTeamEditText.text.toString())

            sharedPreferencesEditor.putString("SECONDTEAM", secondTeamEditText2.text.toString())

            sharedPreferencesEditor.apply()

            val intent = Intent(this, game::class.java)
            startActivity(intent)
        }


    }
}
