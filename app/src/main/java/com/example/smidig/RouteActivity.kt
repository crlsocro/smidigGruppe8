package com.example.smidig

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.smidig.History.HistoryActivity
import com.example.smidig.database.MarkerDao
import com.example.smidig.database.MultiDatabase
import com.example.smidig.History.InfoActivity
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class RouteActivity : AppCompatActivity(), GoogleMap.OnMyLocationButtonClickListener,
GoogleMap.OnMyLocationClickListener, OnMapReadyCallback,
    ActivityCompat.OnRequestPermissionsResultCallback,
GoogleMap.OnMarkerClickListener {

    private var permissionDenied = false
    private lateinit var map: GoogleMap
    var mrkr = MarkerOptions()
            .position(LatLng(59.910, 10.720))
            .title("1")

    var mrkr2 = MarkerOptions()
            .position(LatLng(59.920, 10.730))
            .title("2")

    var mrkr3 = MarkerOptions()
            .position(LatLng(59.930, 10.750))
            .title("3")

    var mrkr4 = MarkerOptions()
            .position(LatLng(59.940, 10.740))
            .title("4")

    var mrkr5 = MarkerOptions()
            .position(LatLng(59.950, 10.720))
            .title("5")

    val mrkrArray = arrayOf(mrkr, mrkr2, mrkr3, mrkr4, mrkr5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        supportActionBar?.hide()
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(this)
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation3)
        bottomNavigation.setOnNavigationItemSelectedListener(navigation)

        val goBackBtn = findViewById<ImageView>(R.id.backIcon)
        goBackBtn.setOnClickListener {
            val i = Intent(this, InfoActivity::class.java)
            startActivity(i)
        }
    }
    private val navigation = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.home -> {
                return@OnNavigationItemSelectedListener false
            }
            R.id.homepage -> {
                val intent = Intent(this@RouteActivity, SigninActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.history -> {
                val intent = Intent(this@RouteActivity, HistoryActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.profile -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false

    }
    
    override fun onMapReady(googleMap: GoogleMap?) {

        val markerDao : MarkerDao = MultiDatabase.get(this).getMDao()
        if(markerDao.checkEmpty() == 0) {
            var markerTest : com.example.smidig.database.Marker = com.example.smidig.database.Marker(0, 59.910, 10.720,false, "fsafs")
            var markerTest2 : com.example.smidig.database.Marker = com.example.smidig.database.Marker(0, 59.920, 10.730,false, "fsafs")
            var markerTest3 : com.example.smidig.database.Marker = com.example.smidig.database.Marker(0, 59.930, 10.750,false, "fsafs")
            var markerTest4 : com.example.smidig.database.Marker = com.example.smidig.database.Marker(0, 59.940, 10.740,false, "fsafs")
            var markerTest5 : com.example.smidig.database.Marker = com.example.smidig.database.Marker(0, 59.950, 10.720,false, "fsafs")
            markerDao.addMarker(markerTest)
            markerDao.addMarker(markerTest2)
            markerDao.addMarker(markerTest3)
            markerDao.addMarker(markerTest4)
            markerDao.addMarker(markerTest5)
        }

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

        println(intent?.getStringExtra("markerValue"))

        map.apply {
                for (i in 1..5) {
                    var clicked = markerDao.getMarker(i).clicked
                    if (clicked) {
                        mrkrArray[i-1].icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                        addMarker(mrkrArray[i-1])
                    } else {
                        addMarker(mrkrArray[i-1])
                    }

                }
        }

        map.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(
                        this, R.raw.style_json
                )
        )
    }

    override fun onMarkerClick(marker: Marker?): Boolean {
        val markerDao : MarkerDao = MultiDatabase.get(this).getMDao()
        for(i in 1..5) {
            if(marker?.title == mrkrArray[i-1].title) {
                markerDao.setClicked(i)
                val intent = Intent(this, PostActivity::class.java)
                startActivity(intent)
            }
            else {

            }
        }

        return true
    }

    /**
     * Enables the My Location layer if the fine location permission has been granted.
     */
    private fun enableMyLocation() {
        if (!::map.isInitialized) return
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED
        ) {
            map.isMyLocationEnabled = true
        } else {
            // Permission to access the location is missing. Show rationale and request permission
            PermissionUtils.requestPermission(
                this, LOCATION_PERMISSION_REQUEST_CODE,
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

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
            return
        }
        if (PermissionUtils.isPermissionGranted(
                permissions,
                grantResults,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        ) {
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
        PermissionUtils.PermissionDeniedDialog.newInstance(true)
            .show(supportFragmentManager, "dialog")
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