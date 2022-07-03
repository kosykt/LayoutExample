package com.example.gb_hw_les_4

import android.os.CountDownTimer
import android.widget.TextView
import java.text.SimpleDateFormat

fun getListHomeWorks() = listHomeWork
fun getListLessons() = listLessons

data class HomeWork(
    val lesson: String,
    val time: String,
    val description: String,
)

private val listHomeWork = listOf(
    HomeWork(
        lesson = "Literature",
        time = "2 days left",
        description = "Read scenes 1.1-1.12 of The Master and Margarita"
    ),
    HomeWork(lesson = "Physics", time = "5 days left", description = "Learn Newton's law"),
    HomeWork(lesson = "Math", time = "7 days left", description = "Solve equations №5-10"),
    HomeWork(
        lesson = "History",
        time = "10 days left",
        description = "Study the theory of evolution"
    )
)

data class Lesson(
    val lesson: String,
    val time: String,
    val teacher: String,
    val canOpenIn: Boolean,
    val description: String,
)

private val listLessons = listOf(
    Lesson(
        lesson = "History",
        time = "08:00-08:45",
        teacher = "Mrs. Tomas",
        canOpenIn = true,
        description = ""
    ),
    Lesson(
        lesson = "Literature",
        time = "09:00-09:45",
        teacher = "Mrs. Barros",
        canOpenIn = true,
        description = ""
    ),
    Lesson(
        lesson = "Physical Education",
        time = "10:00-10:45",
        teacher = "Mr. Barros",
        canOpenIn = false,
        description = "Intensive preparation for The Junior World Championship in Los Angeles"
    ),
    Lesson(
        lesson = "Math",
        time = "11:00-11:45",
        teacher = "Mrs. Tomas",
        canOpenIn = true,
        description = ""
    ),
    Lesson(
        lesson = "Literature",
        time = "12:00-12:45",
        teacher = "Mrs. Barros",
        canOpenIn = true,
        description = ""
    ),
)

class MyTimer(
    private val h1: TextView,
    private val h2: TextView,
    private val m1: TextView,
    private val m2: TextView,
    private val s1: TextView,
    private val s2: TextView,
) : CountDownTimer(99999999, 1000) {

    override fun onTick(millisUntilFinished: Long) {
        val format = SimpleDateFormat("hh:mm:ss")
        val stringTime: String = format.format(millisUntilFinished)
        h1.text = stringTime[0].toString()
        h2.text = stringTime[1].toString()
        m1.text = stringTime[3].toString()
        m2.text = stringTime[4].toString()
        s1.text = stringTime[6].toString()
        s2.text = stringTime[7].toString()
    }

    override fun onFinish() {
        h1.text = "0"
        h2.text = "0"
        m1.text = "0"
        m2.text = "0"
        s1.text = "0"
        s2.text = "0"
    }
}