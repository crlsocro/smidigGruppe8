package com.example.smidig.database

import androidx.room.*

//This DAO controls how to access the information
@Dao
interface MarkerDao {
    @Insert
    fun addMarker(marker: Marker)

    @Update
    fun update(marker: Marker)

    @Delete
    fun delete(marker: Marker)

    //Several SQL commands to select and update markers/pins

    @Query("SELECT * FROM marker_table")
    fun getAllMarkers(): List<Marker>

    @Query("SELECT * FROM marker_table WHERE markerID = :id")
    fun getMarker(id: Int): Marker

    @Query("UPDATE marker_table SET clicked = :clicked WHERE markerID = :id")
    fun setClicked(id: Int, clicked: Int)

    @Query("SELECT COUNT(markerID) FROM marker_table")
    fun checkEmpty(): Int

}