package com.example.smidig.History

class HistoryDummy {
    fun getHistory(): List<HistoryStats>
    {
        var list = ArrayList<HistoryStats>()

        list.add(HistoryStats(1,"Oslo", "Aker Brygge", 5))
        list.add(HistoryStats(2,"Slottet i Oslo", "Slottet", 4))
        list.add(HistoryStats(3,"Frogner i Oslo", "Frognerparken", 8))
        list.add(HistoryStats(4,"Ullevål i Oslo", "Ullevål", 3))
        list.add(HistoryStats(5,"vestkanttorget", "Majorstuen", 2))

        return list
    }
}