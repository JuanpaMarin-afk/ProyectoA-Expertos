package com.example.proyectoa_expertos

class User {

    var id:Int = 0
    var username:String = ""
    var intelligence:String = ""
    var score: Int = 0

    constructor(username:String, intelligence: String, score: Int){
        this.username = username
        this.intelligence = intelligence
        this.score = score
    }
}