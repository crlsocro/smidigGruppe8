package com.example.smidig.History

object InfoConstants {
    fun getInfo(): ArrayList<Info>{
        val infoList = ArrayList<Info>()
        val info1 = Info(
                1,
                "Nonneseter kloster ble sannsynligvis grunnlagt i ca.1150 og er omtalt av Snorre. \n " +
                        "Klosteret tilhørte benediktinerordens kvinnelige gren. Klosteret var viet til den hellige Maria.\n " +
                        " Klosteret var en stor jordeier og eide helt eller delvis 272 gårder i Østlandsområdet. Klosteret lå nær Hovinbekken og lå utenfor middelalderbyen. \n " +
                        "Et hjørne av det man mener kan ha vært klosterkirken ble funnet da Schweigaards gate ble utbedret i 1879. \n " +
                        "To år tidligere kan store deler av kirken ha blitt fjernet da man bygde Schweigaards gate 50. \n " +
                        "Det skal finnes rester under Schweigaards gate 55 og Grønlandsleiret 73"
        )
        infoList.add(info1)
        return infoList
    }
}