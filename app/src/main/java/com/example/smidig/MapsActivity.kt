package com.example.smidig

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smidig.BuildConfig.GOOGLE_MAPS_API_KEY
import com.google.android.gms.location.LocationServices
import com.google.android.libraries.places.api.Places

class MapsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
    }
}