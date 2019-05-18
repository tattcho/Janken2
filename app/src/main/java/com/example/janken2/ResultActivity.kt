package com.example.janken2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    val gu=0
    val choki=1
    val pa=2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val id = intent.getIntExtra("MY_HAND",0)

        val myHand:Int

        myHand=when(id) {
            R.id.gu -> {
                myHandImage.setImageResource(R.drawable.gu)
                gu
            }
            R.id.choki -> {
                myHandImage.setImageResource(R.drawable.choki)
                choki
            }
            R.id.pa -> {
                myHandImage.setImageResource(R.drawable.pa)
                pa
            }
            else ->pa
        }
            //コンピュータの手を決める
            val comHand=(Math.random()*3).toInt()
            when(comHand){
                gu -> comHandImage.setImageResource(R.drawable.com_gu)
                choki -> comHandImage.setImageResource(R.drawable.com_choki)
                pa -> comHandImage.setImageResource(R.drawable.com_pa)
            }

             //勝敗を判定する
            val gameResult = (comHand-myHand+3)%3
            when(gameResult){
                0->resultLabel.setText(R.string.result_draw)
                1->resultLabel.setText(R.string.result_win)
                2->resultLabel.setText(R.string.result_lose)
            }


                    backButton.setOnClickListenner{finish()}


    }

    private fun saveData(myHand: Int,comHand: Int,gameResult: Int){
        val preferenceManager = null
        val pref = preferenceManager.getDefaultSharedpreferences(this)
        val gameCount = pref.getInt("GAME_COUNT",0)
        val winningStreakCount =pref.getInt("WINNG_STREAK_COUNT",0)
        val lastComHand = pref.getInt("LAST_COM_HAND",0)
        val lastGamResult = pref.getInt("GAME_RESULT",-1)

        val editor = pref.edit()
        val gamecount
        editor.putInt("GAME_COUNT",gamecount+1)
            .putInt("WINNING_STREAK_COUNT",
                if (lastGameResult ==2 && gameResult ==2)
                    winningStreakCount + 1
                else
                    0)
            .putInt("LAST_MYHAND",myHand)
                     .putInt("LAST_COM_HAND",comHand)
            .putInt("BEFORE_LAST_COM_HAND",lastComHand)
            .apply()
    }

    fun onJankenButtonTapped(view: View?){
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("My_HAND",view?.id)
        startActivity(intent)
    }
}

object lastGameResult {

}

private fun Any.putInt(s: String, any: Any): Any {

}

private fun Any.getInt(s: String, i: Int): Any {

}

private fun Nothing?.getDefaultSharedpreferences(resultActivity: ResultActivity): Any {

}

private fun Button.setOnClickListenner(function: () -> Unit) {

}
