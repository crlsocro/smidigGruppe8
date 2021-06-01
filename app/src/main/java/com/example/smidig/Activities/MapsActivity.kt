package com.example.smidig.Activities

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
import androidx.core.content.ContextCompat
import com.example.smidig.PermissionUtils.PermissionDeniedDialog.newInstance
import com.example.smidig.PermissionUtils.isPermissionGranted
import com.example.smidig.PermissionUtils.requestPermission
import com.example.smidig.R
import com.example.smidig.database.MarkerDao
import com.example.smidig.database.MultiDatabase
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.google.android.material.bottomnavigation.BottomNavigationView

//Most of the code in this Activity is inspired from https://developers.google.com/maps/documentation

class MapsActivity : AppCompatActivity(), GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnMyLocationClickListener, OnMapReadyCallback, OnRequestPermissionsResultCallback,
        GoogleMap.OnMarkerClickListener {

    //Navigation through screens via footer
    private val navigation = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.homepage -> {
                val intent = Intent(this@MapsActivity, MapsActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.history -> {
                val intent = Intent(this@MapsActivity, HistoryActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.profile -> {
                val intent = Intent(this@MapsActivity, SigninActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
        }
        false

    }

    private var permissionDenied = false
    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        supportActionBar?.hide()
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(this)

        //Onclick
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation3)
        bottomNavigation.setOnNavigationItemSelectedListener(navigation)

        val goBackBtn = findViewById<ImageView>(R.id.backIcon)
        goBackBtn.setOnClickListener {
            val i = Intent(this, SigninActivity::class.java)
            startActivity(i)
        }

        var infoBtn = findViewById<ImageView>(R.id.infoIcon)
        infoBtn.setOnClickListener{
            val popUp = PopupMenu(this, infoBtn)
            val popUpToast = Toast.makeText(applicationContext,
                "Velg en løype du vil følge \n",
                Toast.LENGTH_SHORT).show()
        }
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        //All below is inspired from the documentation
        map = googleMap ?: return
        map.setMinZoomPreference(13f)
        map.setOnMarkerClickListener(this)
        val osloCoordinates = LatLngBounds(
            LatLng(59.910, 10.720),
            LatLng(59.913, 10.769)
        )
        map.setLatLngBoundsForCameraTarget(osloCoordinates)
        googleMap.setOnMyLocationButtonClickListener(this)
        googleMap.setOnMyLocationClickListener(this)
        enableMyLocation()
        googleMap.apply {
            val testMarker = LatLng(59.910, 10.720)
            addMarker(
                    MarkerOptions()
                            .position(testMarker)
                            .title("INSERT MARKER HERE")
            )
        }
        map.setMapStyle(
            MapStyleOptions.loadRawResourceStyle(
                this, R.raw.style_json
            )
        )

        val markerDao : MarkerDao = MultiDatabase.get(this).getMDao()
        if(markerDao.checkEmpty() == 0) {
            var markerTest : com.example.smidig.database.Marker = com.example.smidig.database.Marker(0, 59.910, 10.720,false, "fsafs")
            var markerTest2 : com.example.smidig.database.Marker = com.example.smidig.database.Marker(0, 59.920, 10.730,false, "fsafs")
            var markerTest3 : com.example.smidig.database.Marker = com.example.smidig.database.Marker(0, 59.930, 10.750,false, "fsafs")
            var markerTest4 : com.example.smidig.database.Marker = com.example.smidig.database.Marker(0, 59.920, 10.740,false, "fsafs")
            var markerTest5 : com.example.smidig.database.Marker = com.example.smidig.database.Marker(0, 59.910, 10.730,false, "fsafs")
            markerDao.addMarker(markerTest)
            markerDao.addMarker(markerTest2)
            markerDao.addMarker(markerTest3)
            markerDao.addMarker(markerTest4)
            markerDao.addMarker(markerTest5)
            var historyMarker : com.example.smidig.database.Marker = com.example.smidig.database.Marker(0, 59.910, 10.720,false, "fsafs")
            var historyMarker2 : com.example.smidig.database.Marker = com.example.smidig.database.Marker(0, 59.920, 10.730,false, "fsafs")
            var historyMarker3 : com.example.smidig.database.Marker = com.example.smidig.database.Marker(0, 59.930, 10.750,false, "fsafs")
            var historyMarker4 : com.example.smidig.database.Marker = com.example.smidig.database.Marker(0, 59.920, 10.740,false, "fsafs")
            var historyMarker5 : com.example.smidig.database.Marker = com.example.smidig.database.Marker(0, 59.910, 10.730,false, "fsafs")
            markerDao.addMarker(historyMarker)
            markerDao.addMarker(historyMarker2)
            markerDao.addMarker(historyMarker3)
            markerDao.addMarker(historyMarker4)
            markerDao.addMarker(historyMarker5)
        }
    }

    override fun onMarkerClick(marker: Marker?): Boolean {
        val intent = Intent(this, MarkerActivity::class.java)
        startActivity(intent)
        return false
    }

    /**
     * Enables the My Location layer if the fine location permission has been granted.
     */
    private fun enableMyLocation() {
        if (!::map.isInitialized) return
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            map.isMyLocationEnabled = true
        } else {
            // Permission to access the location is missing. Show rationale and request permission
            requestPermission(this, LOCATION_PERMISSION_REQUEST_CODE,
                    Manifest.permission.ACCESS_FINE_LOCATION, true
            )
        }
    }

    override fun onMyLocationButtonClick(): Boolean {
        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show()
        // Return false so that we don't consume the event and the default behavior still occurs
        // (the camera animates to the user's current position).
        return false
    }

    override fun onMyLocationClick(location: Location) {
        Toast.makeText(this, "Current location:\n$location", Toast.LENGTH_LONG).show()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
            return
        }
        if (isPermissionGranted(permissions, grantResults, Manifest.permission.ACCESS_FINE_LOCATION)) {
            // Enable the my location layer if the permission has been granted.
            enableMyLocation()
        } else {
            // Permission was denied. Display an error message
            // Display the missing permission error dialog when the fragments resume.
            permissionDenied = true
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        if (permissionDenied) {
            // Permission was not granted, display error dialog.
            showMissingPermissionError()
            permissionDenied = false
        }
    }

    /**
     * Displays a dialog with error message explaining that the location permission is missing.
     */
    private fun showMissingPermissionError() {
        newInstance(true).show(supportFragmentManager, "dialog")
    }

    companion object {
        /**
         * Request code for location permission request.
         *
         * @see .onRequestPermissionsResult
         */
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }
}
