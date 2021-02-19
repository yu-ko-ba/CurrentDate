package com.example.currentdate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.time.LocalDate
import java.time.chrono.JapaneseDate
import java.time.chrono.JapaneseEra

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onStart() {
        super.onStart()

        val today = LocalDate.now()
        val japaneseToday = JapaneseDate.now()
        var japaneseEra = japaneseToday.era.toString()
        if (japaneseEra == "Reiwa") {
            japaneseEra = "令和"
        }
        val weeks = arrayOf("月曜日", "火曜日", "水曜日", "木曜日", "金曜日", "土曜日", "日曜日")
        val dateText = findViewById<TextView>(R.id.date_text)
        dateText.text = "${today.year}年(${japaneseEra}${japaneseToday.era.value}年) ${today.month.value}月${today.dayOfMonth}日 ${weeks[today.dayOfWeek.value]}"
    }
}