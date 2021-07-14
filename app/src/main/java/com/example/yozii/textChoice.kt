package com.example.yozii

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class textChoice : AppCompatActivity() {
    var answeredCount = 0
    var answerText = ""
    var answerArray: ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_choice)

        setData()
    }

    private fun setData() {
        var sentenceText: TextView = findViewById(R.id.textView)
        var candidate1Button: RadioButton = findViewById(R.id.candidate1)
        var candidate2Button: RadioButton = findViewById(R.id.candidate2)
        var candidate3Button: RadioButton = findViewById(R.id.candidate3)
        candidate1Button.isChecked = true

        data class Jukugo(val sentence: String, val answer: String, val candidate1: String, val candidate2: String, val candidate3: String)
        val jukugos = listOf(
            Jukugo("The last effort just before the work is completed. Every effort to overlay to complete the work",
                "一簣之功", "一簣之功", "運否天賦", "胆大心小"
            ),
            Jukugo("Irreconcilable enemy",
                "不倶戴天", "哀矜懲創", "不倶戴天", "一超直入"
            ),
            Jukugo("storm and stress; Sturm und Drang",
                "疾風怒濤", "疾風怒濤", "多感多愁", "慇懃尾篭"
            ),
            Jukugo("wind streams in nature",
                "嘯風弄月", "破天荒解", "金泥精描", "嘯風弄月"
            ),
            Jukugo("sharp-sightedness",
                "電光石火", "十風五雨", "恍然大悟", "電光石火"
            ),
            Jukugo("being rampant; domination",
                "跳梁跋扈", "含笑入地", "跳梁跋扈", "銀杯羽化"
            ),
//            Jukugo("clear and serene (as a polished mirror and still water)",
//                "明鏡止水", "一樹百穫", "明鏡止水", "三尺童子"
//            ),
//            Jukugo("evil spirits",
//                "魑魅魍魎", "魑魅魍魎", "履霜之戒", "長目飛耳"
//            ),
//            Jukugo("Beautiful scenery of nature. It also refers to the wind stream that enthralls poetry and paintings with natural objects as their theme",
//                "花鳥風月", "和羹塩梅", "花鳥風月", "妖姿媚態"
//            ),
//            Jukugo("Natural landscape is beautiful. Beautiful views of mountains and rivers",
//                "山紫水明", "一毛不抜", "大味必淡", "山紫水明"
//            ),
//            Jukugo("The winter snow, the autumn moon, the summer wind, spring flowers meaning the beautiful scenery of the seasons from nature. Also, it is an airflow appearance that appreciates it and makes poetry and songs",
//                "雪月風花", "金石之交", "是非曲直", "雪月風花"
//            ),
//            Jukugo("Various kinds of flowers bloom in colorfully. A situation where many excellent people gather together",
//                "百花繚乱", "管鮑之交", "百花繚乱", "軽諾寡信"
//            ),
//            Jukugo("n the sense that the fallen flowers flow according to the water, the scenery of the spring scenery and decay of things going on. The time passes away vainly. The feelings of men and women can communicate with each other and stay in love",
//                "落花流水", "麟子鳳雛", "落花流水", "雪隠大工"
//            ),
            )
        try {
            val jukugo = jukugos.random()

            sentenceText.text = jukugo.sentence
            answerText = jukugo.answer
            candidate1Button.text = jukugo.candidate1
            candidate2Button.text = jukugo.candidate2
            candidate3Button.text = jukugo.candidate3

            if (answerArray.contains(answerText)){
                setData()
            }
            answerArray.add(answerText)

        } catch (e: Exception) {

            e.printStackTrace()
        }
    }


    fun check (viw: View) {
        val radioGroup: RadioGroup = findViewById(R.id.select_group)
        val checkedButtonId = radioGroup.checkedRadioButtonId
        val answeredText = findViewById<RadioButton>(checkedButtonId)

        if (answerText == answeredText.text) {
            if (answeredCount == 5) {
                Toast.makeText(applicationContext, "you finished", Toast.LENGTH_SHORT).show()

                intent = Intent(
                    applicationContext,
                    MainActivity::class.java
                )
                startActivity(intent)
            } else {
                setData()
                answeredCount++
            }
        } else {
            Toast.makeText(applicationContext, "wrong answer", Toast.LENGTH_SHORT).show()
        }
    }
}