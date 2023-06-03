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

    val values = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)


    private var Position: Int = 0
    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var IntelligenceMatrix: ArrayList<IntelligenceScore>? = null
    private var mPoints: Array<Array<Int>>? = null
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
                Position = position
                //Toast.makeText(this@QuestionsActivity, "" + IntelligenceMatrix, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        mUserName = intent.getStringExtra(Constants.USER_NAME)
        IntelligenceMatrix = Constants.getIntelligences()
        mQuestionsList = Constants.getQuestions()
        mPoints = Constants.getPoints()
        setQuestion()

        val btn_submit = findViewById<Button>(R.id.btn_submit)
        val auto = findViewById<TextView>(R.id.titleEscala)

        btn_submit.setOnClickListener(this)
        auto.setOnClickListener {
            autoFill()
            val intent =
                Intent(this@QuestionsActivity, ResultActivity::class.java)
            intent.putExtra(Constants.USER_NAME, mUserName)
            intent.putExtra(Constants.INTELLIGENCE, selectIntelligence())
            intent.putExtra(Constants.SCORE, getScore())
            startActivity(intent)
            finish()
        }
    }

    override fun onClick(v: View?) {
        setPoints(values[Position],mCurrentPosition-1)
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
                        intent.putExtra(Constants.INTELLIGENCE, selectIntelligence())
                        intent.putExtra(Constants.SCORE, getScore())
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

    private fun setPoints(value: Int, pos: Int){
        var p = pos
        while(p > 11){
            p = p - 12
        }
        for(i in 0..11){
            IntelligenceMatrix!![i].score = IntelligenceMatrix!![i].score  + value + mPoints!![i][p]
        }
    }

    private fun selectIntelligence(): String{
        var pos = 0
        var preValue = 0
        for(i in 0..11){
            if(IntelligenceMatrix!![i].score >= preValue){
                pos = i
                preValue = IntelligenceMatrix!![pos].score
            }
        }
        return IntelligenceMatrix!![pos].intelligence
    }

    private fun getScore(): String {
       var result = 0
       for(i in 0..11){
           result += IntelligenceMatrix!![i].score
       }
        return result.toString()
    }

    private fun autoFill() {
        for(i in 0..36) {
            setPoints(values[(Math.random() * (9 - 0 + 1)).toInt() + 0], i)
        }
    }
}