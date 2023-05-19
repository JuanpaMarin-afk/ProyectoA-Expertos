package com.example.proyectoa_expertos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_iniciar = findViewById(R.id.btn_iniciar) as Button
        val user_name = findViewById(R.id.test_name) as TextView

        btn_iniciar.setOnClickListener {

            if (user_name.text.toString().isEmpty()) {

                Toast.makeText(this@MainActivity, "Ingrese un nombre!", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val intent = Intent(this@MainActivity, QuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, user_name.text.toString())
                startActivity(intent)
                finish()
            }
        }

    }
}