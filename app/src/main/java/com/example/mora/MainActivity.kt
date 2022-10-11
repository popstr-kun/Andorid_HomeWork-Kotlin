package com.example.mora

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView



class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edName    :EditText    = findViewById(R.id.ed_name)
        val btnScissor:RadioButton = findViewById(R.id.btn_scissor)
        val btnStone  :RadioButton = findViewById(R.id.btn_stone)
        val btnPaper  :RadioButton = findViewById(R.id.btn_paper)
        val btnMora   :Button      = findViewById(R.id.btn_mora)
        val tvText    :TextView    = findViewById(R.id.tv_text)
        val tvName    :TextView    = findViewById(R.id.tv_name)
        val tvWinner  :TextView    = findViewById(R.id.tv_winner)
        val tvMmora   :TextView    = findViewById(R.id.tv_mmora)
        val tvCmora   :TextView    = findViewById(R.id.tv_cmora)

        btnMora.setOnClickListener{
            if(edName.length() < 1) tvText.text = "請輸入玩家姓名"
            else{
                tvName.text = "名字\n${edName.text}"


                if(btnScissor.isChecked) tvMmora.text = "我方出拳\n剪刀"
                else if (btnStone.isChecked) tvMmora.text = "我方出拳\n石頭"
                else tvMmora.text = "我方出拳\n布"

                val computer : Int = (0..2).random()

                when (computer) {
                    0 -> tvCmora.text = "電腦出拳\n刀剪"
                    1 -> tvCmora.text = "電腦出拳\n石頭"
                    2 -> tvCmora.text = "電腦出拳\n布"
                }

                if(
                    (btnScissor.isChecked) && (computer == 2) ||
                    (btnStone.isChecked)   && (computer == 0) ||
                    (btnPaper.isChecked)   && (computer == 1)
                ){
                    tvWinner.text = "勝利者\n"+edName.text.toString()
                    tvText.text   = "恭喜你獲勝"
                }
                else if((btnScissor.isChecked && computer == 1)||
                        (btnStone.isChecked   && computer == 2)||
                        (btnPaper.isChecked   && computer == 0)
                ){
                    tvWinner.text = "勝利者\n電腦"
                    tvText.text   = "可惜，電腦獲勝了！"
                }
                else{
                    tvWinner.text = "勝利者\n平手"
                    tvText.text   = "平局，請在試一次!"
                }
            }
        }

    }




}