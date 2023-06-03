package com.example.proyectoa_expertos

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class ResultActivity : AppCompatActivity() {

    lateinit var binding: ResultActivity
    lateinit var intelligenceDBHelper: SQLLite
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val userName = intent.getStringExtra(Constants.USER_NAME)
        val intelligence = intent.getStringExtra(Constants.INTELLIGENCE)
        val score = intent.getStringExtra(Constants.SCORE)

        val tv_name = findViewById<TextView>(R.id.tv_name)
        tv_name.text = userName
        val tv_intelligence = findViewById<TextView>(R.id.tv_intelligence)
        tv_intelligence.text = intelligence
        val tv_score = findViewById<TextView>(R.id.tv_score)
        tv_score.text = score

        intelligenceDBHelper = SQLLite(this)
        var db: SQLiteDatabase? = intelligenceDBHelper.readableDatabase
        val cursor = db?.rawQuery("SELECT * FROM intelligence_history WHERE id = (SELECT MAX(id) FROM intelligence_history)", null)
        var lastUser: User? = User("a","a",0) //null
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    val username = cursor.getString(1).toString()
                    val intelligence = cursor.getString(2).toString()
                    val score = cursor.getInt(3)
                    lastUser = User(username,intelligence,score)
                } while (cursor.moveToNext())
            }
        }

        //Add to the BD the username and the intelligence
        if(lastUser != null){
           if(lastUser.username != userName || lastUser.intelligence != intelligence || lastUser.score != score?.toInt()) {
                if (userName != null && intelligence != null && score != null) {
                    intelligenceDBHelper.addData(userName, intelligence, score.toInt())
                }
            }
        }

        val btn_match = findViewById<Button>(R.id.btn_match)
        btn_match.setOnClickListener {
            val intent = Intent(this@ResultActivity, MatchActivity::class.java)
            intent.putExtra(Constants.USER_NAME, userName)
            intent.putExtra(Constants.INTELLIGENCE, intelligence)
            intent.putExtra(Constants.SCORE, score)
            startActivity(intent)
            finish()
        }

        val btn_finish = findViewById<Button>(R.id.btn_finish)
        btn_finish.setOnClickListener {
            startActivity(Intent(this@ResultActivity, MainActivity::class.java))
        }
    }
    /*
    fun showUsersRelatedTo() {
        var db: SQLiteDatabase? = intelligenceDBHelper.readableDatabase
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
        val cursor2 = db?.rawQuery("SELECT score FROM intelligence_history WHERE id = (SELECT MAX(id) FROM intelligence_history)", null)
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
            Toast.makeText(this@ResultActivity, "datos: " + userList.size, Toast.LENGTH_SHORT).show()
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
    }*/
}