package com.example.smidig.quiz

class QuizDummy {
    fun getQuiz(): List<Questions>{
        var list = ArrayList<Questions>()
        list.add(Questions(1,"Hvem var klosteret viet til?", "Den hellige Maria", "Gud", "Kongen","Ingen", 1))
        list.add(Questions(2,"Hvem var Norges første kvinnelige redaktør?", "Amalie skram", "Kirsten Flagstad", "Josephine Thrane","Gro Harlem Brundtland", 2))
        list.add(Questions(3,"Når ble broen oppførst for første gang?", "1501", "1885", "1702","1654", 4))
        list.add(Questions(4,"Når ble kirkegården nedlagt?", "1880", "1885", "1702","1654", 1))
        list.add(Questions(2," Når ble romanen ulvehiet utgitt?", "1980", "1880", "1919","1910", 3))

        return list

    }
}