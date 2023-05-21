package com.example.proyectoa_expertos

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*

class ResultActivity : AppCompatActivity() {

    lateinit var binding: ResultActivity
    lateinit var intelligenceDBHelper: SQLLite
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val userName = intent.getStringExtra(Constants.USER_NAME)
        val tv_name = findViewById<TextView>(R.id.tv_name)
        tv_name.text = userName

        val intelligence = intent.getStringExtra("EJEMPLO")

        val tv_score = findViewById<TextView>(R.id.tv_score)
        tv_score.text = "Tu inteligencia es: $intelligence"

        //Add to the BD the username and the intelligence
        intelligenceDBHelper = SQLLite(this)
        if (userName != null /*&& intelligence != null*/) {
            intelligenceDBHelper.addData(userName, "ejemplo")
        }

        //Show Table Users Related To
        showUsersRelatedTo()

        val btn_finish = findViewById<Button>(R.id.btn_finish)
        btn_finish.setOnClickListener {
            startActivity(Intent(this@ResultActivity, MainActivity::class.java))
        }
    }

    fun showUsersRelatedTo() {
        val intelligence = intent.getStringExtra("EJEMPLO")
        val db: SQLiteDatabase? = intelligenceDBHelper.readableDatabase
        //val cursor = db?.rawQuery("SELECT * FROM intelligence_history WHERE intelligence = '$intelligence'", null)
        val cursor = db?.rawQuery("SELECT * FROM intelligence_history", null)

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    val tableRow = LayoutInflater.from(this).inflate(R.layout.table_row, null) as TableRow
                    val tableLayout = findViewById<TableLayout>(R.id.tableLayout)

                    val username = cursor.getString(1).toString()
                    tableRow.findViewById<TextView>(R.id.usernameTextView).append(username)

                    val intelligence = cursor.getString(2).toString()
                    tableRow.findViewById<TextView>(R.id.intelligenceTextView).append(intelligence)

                    tableLayout.addView(tableRow)
                } while (cursor.moveToNext())
            }
        }

    }

}