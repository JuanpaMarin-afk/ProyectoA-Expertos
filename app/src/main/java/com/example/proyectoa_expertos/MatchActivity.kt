package com.example.proyectoa_expertos

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MatchActivity : AppCompatActivity() {
    lateinit var binding: MatchActivity
    lateinit var intelligenceDBHelper: SQLLite
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match)

        val userName = intent.getStringExtra(Constants.USER_NAME)
        val tv_name = findViewById<TextView>(R.id.tv_name)
        tv_name.text = userName

        //Show Table Users Related To
        showUsersRelatedTo()

        val btn_back = findViewById<Button>(R.id.btn_back)
        btn_back.setOnClickListener {
            startActivity(Intent(this@MatchActivity, ResultActivity::class.java))
        }
    }

    fun showUsersRelatedTo() {
        var db: SQLiteDatabase = intelligenceDBHelper.readableDatabase
        val cursor = db?.rawQuery("SELECT * FROM intelligence_history WHERE id != (SELECT MAX(id) FROM intelligence_history)", null)
        var userList = ArrayList<User>()
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    val username = cursor.getString(1).toString()
                    val intelligence = cursor.getString(2).toString()
                    val score = cursor.getInt(3)
                    val user = User(username,intelligence,score)

                    userList.add(user)
                } while (cursor.moveToNext())
            }
        }
        db = intelligenceDBHelper.readableDatabase
        val cursor2 = db.rawQuery("SELECT score FROM intelligence_history WHERE id = (SELECT MAX(id) FROM intelligence_history)", null)
        var userScore = 0
        if (cursor2 != null) {
            if (cursor2.moveToFirst()) {
                do {
                    userScore = cursor2.getInt(0)
                } while (cursor2.moveToNext())
            }
        }

        if (userList != null && userList.size > 0) {
            userList = arraySort(userList,userScore)
            Toast.makeText(this@MatchActivity, "datos: " + userList.size, Toast.LENGTH_SHORT).show()
            var i = 0
            do {
                val tableRow = LayoutInflater.from(this).inflate(R.layout.table_row, null) as TableRow
                val tableLayout = findViewById<TableLayout>(R.id.tableLayout)

                val username = userList[i].username
                tableRow.findViewById<TextView>(R.id.usernameTextView).append(username)

                val intelligence = userList[i].intelligence
                tableRow.findViewById<TextView>(R.id.intelligenceTextView).append(intelligence)

                tableLayout.addView(tableRow)
                i++
            } while ( i < userList.size)
        }else{
            findViewById<ScrollView>(R.id.scrollview).setVisibility(View.INVISIBLE)
            findViewById<ScrollView>(R.id.scrollview).setLayoutParams(LinearLayout.LayoutParams(20, 50));
            findViewById<TextView>(R.id.tv_noUsers).setVisibility(View.VISIBLE)
        }

    }

    private fun arraySort(array: ArrayList<User>,baseScore: Int): ArrayList<User>{
        var list: ArrayList<User> = array
        var user: User = User("","",0)
        for(i in 0..list.size-2){
            for(j in i+1..list.size-1){
                if(Euclides_MCD(baseScore,list[i].score) > Euclides_MCD(baseScore,list[j].score)) {
                    user = list[i]
                    list[i] = list[j]
                    list[j] = user
                }
            }
        }
        return list
    }

    private fun Euclides_MCD(entradaA: Int, entradaB: Int): Int {
        var a = entradaA
        var b = entradaB
        var r = a % b
        if(b>a){
            val aux: Int = a
            a = b
            b = aux
        }
        if(r != 0) {
            do {
                a = b
                b = r
                r = a % b
            } while (r != 0)
            return b
        }
        return b
    }
    private fun lastUser(): User? {
        var db: SQLiteDatabase? = intelligenceDBHelper.readableDatabase
        val cursor = db?.rawQuery("SELECT * FROM intelligence_history WHERE id = (SELECT MAX(id) FROM intelligence_history)", null)
        var user: User? = null
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    val username = cursor.getString(1).toString()
                    val intelligence = cursor.getString(2).toString()
                    val score = cursor.getInt(3)
                    user = User(username,intelligence,score)
                } while (cursor.moveToNext())
            }
        }
        return user
    }
}