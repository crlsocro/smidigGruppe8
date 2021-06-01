package com.example.smidig.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Here we store the pins on the map. By storing it here we can add more pins and store progress

@Entity(tableName = "marker_table")
data class Marker(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "markerID")
    val markerID: Int,
    @ColumnInfo(name = "latitude")
    val latitude: Double,
    @ColumnInfo(name = "longitude")
    val longitude: Double,
    @ColumnInfo(name = "clicked")
    val clicked: Boolean,
    @ColumnInfo(name = "icon")
    val icon: String?,
)