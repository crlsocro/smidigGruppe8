package com.example.smidig.database

import androidx.room.*

@Dao
interface MarkerDao {
    @Insert
    fun addMarker(marker: Marker)

    @Update
    fun update(marker: Marker)

    @Delete
    fun delete(marker: Marker)

    @Query("SELECT * FROM marker_table")
    fun getAllMarkers(): List<Marker>

    @Query("SELECT * FROM marker_table WHERE markerID = :id")
    fun getMarker(id: Int): Marker

    @Query("UPDATE marker_table SET clicked = 1 WHERE markerID = :id")
    fun setClicked(id: Int)

    @Query("SELECT COUNT(markerID) FROM marker_table")
    fun checkEmpty(): Int

}