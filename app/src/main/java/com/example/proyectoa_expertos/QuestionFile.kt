package com.example.proyectoa_expertos

object Constants {

    const val USER_NAME: String = "user_name"
    const val INTELLIGENCE: String = "intelligence_user_name"

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        // Question 1
        val que1 = Question(
            1, "Question 1?",0
        )
        questionsList.add(que1)

        // Question 2
        val que2 = Question(
            2, "Question 2?",0
        )
        questionsList.add(que2)

        return questionsList
    }
}
