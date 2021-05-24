package com.example.smidig.quiz

object Constants {
    fun getQuestions(): ArrayList<Questions>{
        val qList = ArrayList<Questions>()
        val q1 = Questions(
                1,
                "Hvem var klosteret viet til?",
                "Den hellige Maria",
                "Gud",
                "Kongen",
                "Ingen",
                1
        )
        qList.add(q1)
        val q2 = Questions(
                2,
                "Hvem var Norges første kvinnelige redaktør?",
                "Amalie skram",
                "Kirsten Flagstad",
                "Josephine Thrane",
                "Gro Harlem Brundtland",
                2
        )
        qList.add(q2)
        val q3 = Questions(
                3,
                "Når ble broen oppførst for første gang?",
                "1501",
                "1885",
                "1702",
                "1654",
                4
        )
        qList.add(q3)
        val q4 = Questions(
                4,
                "Når ble kirkegården nedlagt?",
                "1880",
                "1885",
                "1702",
                "1654",
                1
        )
        qList.add(q4)
        val q5 = Questions(
                5,
                " Når ble romanen ulvehiet utgitt?",
                "1980",
                "1880",
                "1919",
                "1910",
                3
        )
        qList.add(q5)
        return qList
    }
}

