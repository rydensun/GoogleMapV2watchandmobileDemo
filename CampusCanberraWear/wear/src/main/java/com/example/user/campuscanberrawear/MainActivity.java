package com.example.user.campuscanberrawear;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback{


    public Button btnEntrance1;
    public Button btnEntrance2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.round_activity_main);
       // final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
       // stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
        //    @Override
        //    public void onLayoutInflated(WatchViewStub stub) {
        //        mTextView = (TextView) stub.findViewById(R.id.text);
        //    }
       // });
        btnEntrance1 = (Button)findViewById(R.id.btnEntrance1);
        btnEntrance2 = (Button)findViewById(R.id.btnEntrance2);
        btnEntrance1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent entrance1 = new Intent(MainActivity.this, StreetView1.class);
                startActivity(entrance1);
            }
        });
        btnEntrance2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent entrance2 = new Intent(MainActivity.this, StreetView2.class);
                startActivity(entrance2);
            }
        });




        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        UiSettings settings = googleMap.getUiSettings();
        settings.setZoomControlsEnabled(true);

        LatLng holmesglen  = new LatLng(-37.874915, 145.090492);
        CameraPosition cameraPosition = CameraPosition.builder()
                .target(holmesglen)
                .zoom(16)
                .bearing(0)
                .tilt(45)
                .build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        LatLng Building3 = new LatLng(-37.876127, 145.087676);
        googleMap.addMarker(new MarkerOptions()
                .position(Building3)
                .title(" Building 3")
                .snippet("Building3 of holmesglen")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        LatLng CarPark = new LatLng(-37.876873, 145.084367);
        googleMap.addMarker(new MarkerOptions()
                .position(CarPark)
                .title("CarPark")
                .snippet("CarPark")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        LatLng Office = new LatLng(-37.874615, 145.091414);
        googleMap.addMarker(new MarkerOptions()
                .position(Office)
                .title("Office")
                .snippet("Holmesglen Office")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
        LatLng BusStop = new LatLng(-37.876293, 145.086382);
        googleMap.addMarker(new MarkerOptions()
                .position(BusStop)
                .title("BusStop")
                .snippet("BusStop")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        LatLng McDonald = new LatLng(-37.875769, 145.091206);
        googleMap.addMarker(new MarkerOptions()
                .position(McDonald)
                .title("McDonald")
                .snippet("McDonald")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        LatLng HolmesglenStation = new LatLng(-37.874562, 145.090188);
        googleMap.addMarker(new MarkerOptions()
                .position(HolmesglenStation)
                .title("HolmesglenStation")
                .snippet("HolmesglenStation")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)));
        LatLng Building4 = new LatLng(-37.876293, 145.086382);
        googleMap.addMarker(new MarkerOptions()
                .position(Building4)
                .title("Building4")
                .snippet("Building4")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));

        googleMap.addPolyline(new PolylineOptions().geodesic(true)
                .add(CarPark)
                .add(Building3)
                .add(BusStop)
                .add(Office)
                .add(McDonald)
                .add(HolmesglenStation)
                .add(Building4));

    }
}
