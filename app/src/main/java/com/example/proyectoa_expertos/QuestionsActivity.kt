package com.example.proyectoa_expertos

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.*
import androidx.core.content.ContextCompat

class QuestionsActivity : AppCompatActivity(), OnClickListener {

    val values = arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0

    private var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        //List Values 0 - 10
        val spinner = findViewById<Spinner>(R.id.spinner)
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, values)
        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@QuestionsActivity, "Opcion = " + values[position], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mQuestionsList = Constants.getQuestions()
        setQuestion()

        val btn_submit = findViewById<Button>(R.id.btn_submit)

        btn_submit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_submit -> {
                mCurrentPosition++
                when {
                    mCurrentPosition <= mQuestionsList!!.size -> {
                        setQuestion()
                    }

                    else -> {
                        val intent =
                            Intent(this@QuestionsActivity, ResultActivity::class.java)
                        intent.putExtra(Constants.USER_NAME, mUserName)
                        startActivity(intent)
                        finish()
                    }
                }

            }
        }
    }

    private fun setQuestion() {
        val question =
            mQuestionsList!!.get(mCurrentPosition - 1)

        val btn_submit = findViewById<Button>(R.id.btn_submit)

        if (mCurrentPosition == mQuestionsList!!.size) {
            btn_submit.text = "Terminar test"
        } else {
            btn_submit.text = "Siguiente"
        }

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val tv_progress = findViewById<TextView>(R.id.tv_progress)
        val tv_question = findViewById<TextView>(R.id.tv_question)

        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.getMax()

        tv_question.text = question.question
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(
            Color.parseColor("#363A43")
        )
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this@QuestionsActivity,
            R.drawable.selected_option_border_bg
        )
    }



}