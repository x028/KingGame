package com.example.alienware.kanggame

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game.*

class game : AppCompatActivity() {

    var firstTeamScore = 0
    var secondTeamScore = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)

        firstTeamTextView.text = sharedPreferences.getString("FIRSTTEAM", "First Value")


        secondTeamTextView.text = sharedPreferences.getString("SECONDTEAM", "Second Value")


        firstTeamScore = sharedPreferences.getInt("FIRSTTEAM_SCORE", 0)
        secondTeamScore = sharedPreferences.getInt("SECONDTEAM_SCORE", 0)

        pluseOneFirstTeamButton.setOnClickListener { firstTeamP1() }
        pluseTwoFirstTeamButton.setOnClickListener { firstTeamP2() }
        pluseThreeFirstTeamButton2.setOnClickListener { firstTeamP3() }

        pluseOneSecondTeamButton.setOnClickListener { secondTeamP1() }
        pluseTwoSecondTeamButton2.setOnClickListener { secondTeamP2() }
        pluseThreeSecondTeamButton.setOnClickListener { secondTeamP3() }

        resetButton3.setOnClickListener { reset() }

        finshButton4.setOnClickListener { finshMatch() }


    }

    override fun onStop() {
        super.onStop()
        val editor = PreferenceManager.getDefaultSharedPreferences(this).edit()
        editor.putInt("FIRSTTEAM_SCORE", firstTeamScore)
        editor.putInt("SECONDTEAM_SCORE", secondTeamScore)
        editor.apply()
    }

    fun firstTeamP1() {
        firstTeamScore++
        resultFirstscoreTextView.text = firstTeamScore.toString()
    }

    fun firstTeamP2() {
        firstTeamScore += 2
        resultFirstscoreTextView.text = firstTeamScore.toString()
    }

    fun firstTeamP3() {
        firstTeamScore += 3
        resultFirstscoreTextView.text = firstTeamScore.toString()
    }

    fun secondTeamP1() {
        secondTeamScore++
        resultSecontTeamTextView.text = secondTeamScore.toString()
    }

    fun secondTeamP2() {
        secondTeamScore += 2
        resultSecontTeamTextView.text = secondTeamScore.toString()
    }

    fun secondTeamP3() {
        secondTeamScore += 3
        resultSecontTeamTextView.text = secondTeamScore.toString()
    }

    fun finshMatch() {

        var message: String

        if (firstTeamScore == secondTeamScore)
            message = "It's a draw!"
        else if (firstTeamScore > secondTeamScore)
            message = "First Team Won!"
        else
            message = "Second Team Won!"



        Toast.makeText(this, message?.toString(), Toast.LENGTH_LONG).show()

    }

    fun reset() {
        firstTeamScore = 0
        secondTeamScore = 0
        resultFirstscoreTextView.text = firstTeamScore.toString()
        resultSecontTeamTextView.text = secondTeamScore.toString()
    }


}
