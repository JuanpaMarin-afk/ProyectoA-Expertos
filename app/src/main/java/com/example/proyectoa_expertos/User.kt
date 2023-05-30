package com.example.proyectoa_expertos

class User {

    var id:Int = 0
    var username:String = ""
    var intelligence:String = ""

    constructor(username:String, intelligence: String){
        this.username = username
        this.intelligence = intelligence
    }
}