package com.example.proyectoa_expertos

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.TextView
import java.util.ArrayList
import java.util.Objects

class SQLLite(context: Context) : SQLiteOpenHelper(
    context, "intelligences.db", null, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        val orderCreation = "CREATE TABLE intelligence_history " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "username VARCHAR(100), intelligence VARCHAR(100))"
        db?.execSQL(orderCreation)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //val orderDelete = "DROP TABLE IF EXISTS intelligence_history"
        //db!!.execSQL(orderDelete)
        //onCreate(db)
    }

    fun addData(username: String, intelligence: String): String{
        val db = this.writableDatabase
        val data = ContentValues()
        data.put("username", username)
        data.put("intelligence", intelligence)

        var result = db.insert("intelligence_history", null, data)
        if(result == -1.toLong()){
            return "error"
        }else{
            return "exito"
        }
        db.close()
    }
    @SuppressLint("Range")
    fun getData():MutableList<User>{
        var list:MutableList<User> = ArrayList()

        val db = this.readableDatabase
        val sql = "SELECT * FROM intelligence_history"
        var result = db.rawQuery(sql, null)

        if (result.moveToFirst()) {
            do {
                var username = result.getString(result.getColumnIndex("username"))
                var intelligence = result.getString(result.getColumnIndex("intelligence"))
                var user = User(username,intelligence)
                list.add(user)
            } while (result.moveToNext())
            result.close()
            db.close()
        }

        return list
    }

}