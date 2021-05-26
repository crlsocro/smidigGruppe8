package com.example.smidig.History

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
import com.example.smidig.MapsActivity
import com.example.smidig.PermissionUtils
import com.example.smidig.PostActivity
import com.example.smidig.R
import com.example.smidig.database.MarkerDao
import com.example.smidig.database.MultiDatabase
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.lang.Error

class HistoryRouteActivity : AppCompatActivity(), GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnMyLocationClickListener, OnMapReadyCallback,
        ActivityCompat.OnRequestPermissionsResultCallback,
        GoogleMap.OnMarkerClickListener {

    private var permissionDenied = false
    private lateinit var map: GoogleMap
    var mrkr = MarkerOptions()
            .position(LatLng(59.910, 10.720))
            .title("6")

    var mrkr2 = MarkerOptions()
            .position(LatLng(59.920, 10.730))
            .title("7")

    var mrkr3 = MarkerOptions()
            .position(LatLng(59.930, 10.750))
            .title("8")

    var mrkr4 = MarkerOptions()
            .position(LatLng(59.920, 10.740))
            .title("9")

    var mrkr5 = MarkerOptions()
            .position(LatLng(59.910, 10.730))
            .title("10")

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
                val intent = Intent(this@HistoryRouteActivity, MapsActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.history -> {
                val intent = Intent(this@HistoryRouteActivity, HistoryActivity::class.java)
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

        val markerDao: MarkerDao = MultiDatabase.get(this).getMDao()

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
            for (i in 6..10) {
                var clicked = markerDao.getMarker(i).clicked
                fun checkNext(): Boolean {
                    return if (i != 10) {
                        !markerDao.getMarker(i + 1).clicked && markerDao.getMarker(i - 1).clicked
                    } else {
                        false
                    }
                }

                if (clicked) {
                        mrkrArray[i - 6].icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                        addMarker(mrkrArray[i - 6])
                } else {
                    if(!markerDao.getMarker(6).clicked) {
                        mrkrArray[0].icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                        addMarker(mrkrArray[i - 6])
                    } else {
                        if(checkNext() || (markerDao.getMarker(9).clicked) && !markerDao.getMarker(10).clicked) {
                            mrkrArray[i - 6].icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                            addMarker(mrkrArray[i - 6])
                        } else {
                            mrkrArray[i - 6].icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                            addMarker(mrkrArray[i - 6])
                        }
                    }
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
        val markerDao: MarkerDao = MultiDatabase.get(this).getMDao()
        for (i in 6..10) {
            if (marker?.title == mrkrArray[i - 6].title) {
                if(markerDao.getMarker(i - 1).clicked || markerDao.getMarker(i).markerID == 6){
                    markerDao.setClicked(i, 1)
                    val intent = Intent(this, PostActivity::class.java)
                    startActivity(intent)
                }

            } else {

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