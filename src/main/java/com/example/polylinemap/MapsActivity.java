package com.example.polylinemap;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Untad and move the camera
        LatLng untad = new LatLng(-0.83643, 119.89369);
        LatLng sma5 = new LatLng(-0.8420663, 119.883475);
        // Custom size marker
        int tinggi = 100;
        int lebar = 100;
        BitmapDrawable bitmapStart = (BitmapDrawable)getResources().getDrawable(R.drawable.pin_map_hitam);
        BitmapDrawable bitmapDes = (BitmapDrawable)getResources().getDrawable(R.drawable.pin_map_merah);
        Bitmap s = bitmapStart.getBitmap();
        Bitmap d = bitmapDes.getBitmap();
        Bitmap marketStart = Bitmap.createScaledBitmap(s, lebar, tinggi, false);
        Bitmap markerDes = Bitmap.createScaledBitmap(d, lebar, tinggi, false);

        // Add marker to map
        mMap.addMarker(new MarkerOptions().position(untad).title("Marker in Untad")
                .snippet("ini adalah kampus kami")
                .icon(BitmapDescriptorFactory.fromBitmap(marketStart)));

        mMap.addMarker(new MarkerOptions().position(sma5).title("Marker in SMAN 5 Palu")
                .snippet("Ini adalah SMAN 5 Palu")
                .icon(BitmapDescriptorFactory.fromBitmap(markerDes)));

        mMap.addPolyline(new PolylineOptions().add(
                untad,
                new LatLng(-0.836341, 119.892311),
                new LatLng(-0.836545, 119.892279),
                new LatLng(-0.836384, 119.889565),
                new LatLng(-0.835363, 119.889340),
                new LatLng(-0.836282, 119.889233),
                new LatLng(-0.836282, 119.889233),
                new LatLng(-0.836204, 119.883431),
                new LatLng(-0.836743, 119.883487),
                new LatLng(-0.839093, 119.883360),
                new LatLng(-0.841530, 119.883290),
                new LatLng(-0.841571, 119.884040),
                sma5
                ) .width(10)
                .color(Color.BLUE)
        );

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sma5, 14.5f));
    }
}
