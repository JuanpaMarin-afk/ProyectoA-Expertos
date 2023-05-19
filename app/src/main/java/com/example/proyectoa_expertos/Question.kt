package com.example.proyectoa_expertos

data class Question (
    val id:Int,
    val question:String,
    val optionOne:String,
    val optionTwo:String,
    val correctAnswer:Int
)