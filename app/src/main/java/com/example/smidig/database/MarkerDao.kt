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

}