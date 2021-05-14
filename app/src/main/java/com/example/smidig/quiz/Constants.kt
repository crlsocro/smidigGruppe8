package com.example.smidig.quiz

object Constants {
    fun getQuestions(): ArrayList<Questions>{
        val qList = ArrayList<Questions>()
        val q1 = Questions(
                1,
                "What is 1 + 1?",
                "9",
                "2",
                "4",
                "8",
                2,
        )
        qList.add(q1)
        val q2 = Questions(
                1,
                "What is 2 + 2?",
                "1",
                "6",
                "4",
                "5",
                3,
        )
        qList.add(q2)
        return qList
    }
}