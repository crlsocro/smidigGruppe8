package com.example.smidig.quiz

//This part is inspired from https://www.youtube.com/watch?v=b21fiIyOW4A&t=4896s

object Constants {
    fun getQuestions(): ArrayList<Questions>{
        val qList = ArrayList<Questions>()
        val q1 = Questions(
                1,
                "Hvem var klosteret viet til?",
                "Den hellige Maria",
                "Den Hellige Ånd",
                "Jesus Kristus",
                1
        )
        qList.add(q1)
        val q2 = Questions(
                2,
                "Hvem var Norges første kvinnelige redaktør?",
                "Gro Harlem Brundtland",
                "Kristine Bonnevie",
                "Josephine Thrane",
                3
        )
        qList.add(q2)
        val q3 = Questions(
                3,
                "Når ble broen oppført for første gang?",
                "1836",
                "1942",
                "1654",
                3
        )
        qList.add(q3)
        val q4 = Questions(
                4,
                "Når ble kirkegården nedlagt?",
                "ca 1880",
                "ca 1910",
                "ca 1860",
                1
        )
        qList.add(q4)
        val q5 = Questions(
                5,
                " Når ble romanen Ulvehiet utgitt?",
                "1919",
                "1980",
                "1819",
                1
        )
        qList.add(q5)
        val q6 = Questions(
                6,
                "Hvem ble Oslo bys skytsengel?",
                "Den hellige Maria",
                "St Hallvard",
                "St kristoffer",
                2
        )
        qList.add(q6)
        val q7 = Questions(
                7,
                "Hvem startet byggingen av Akershus festning?",
                "Håkon 5",
                "Olav 1",
                "Freya 2",
                1
        )
        qList.add(q7)
        val q8 = Questions(
                8,
                "Hvorfor ble store deler av Oslo ødelagt?",
                "Jordskjelv",
                "Flom",
                "Brann",
                3
        )
        qList.add(q8)
        val q9 = Questions(
                9,
                "Hvilken krig ble avsluttet rundt 1700-tallet?",
                "Den store svenske krigen",
                "Den store nordiske krige",
                "Den lille norske krigen",
                2
        )
        qList.add(q9)
        val q10 = Questions(
                10,
                "Hvilken elv ble viktig for bygging av industri?",
                "Akerselva",
                "Oslofjorden",
                "Glomma",
                1
        )
        qList.add(q10)
        return qList
    }
}

