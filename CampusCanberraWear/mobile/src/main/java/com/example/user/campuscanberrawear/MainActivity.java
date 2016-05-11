package com.example.user.campuscanberrawear;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    private static final CharSequence[] MAP_TYPE_ITEMS =
            {"Road Map", "Hybrid", "Satellite", "Terrain"};

public Button btnEntrance1;
    public Button btnEntrance2;
    public Button btnType;
    GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnEntrance1 = (Button)findViewById(R.id.btnEntrance1);
        btnEntrance2 = (Button)findViewById(R.id.btnEntrance2);
        btnType = (Button)findViewById(R.id.changeType);
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
        btnType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMapTypeSelectorDialog();
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mMap = mapFragment.getMap();


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        showMapTypeSelectorDialog();
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

    private void showMapTypeSelectorDialog( ) {
        // Prepare the dialog by setting up a Builder.
        final String fDialogTitle = "Select Map Type";
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(fDialogTitle);

        // Find the current map type to pre-check the item representing the current state.
        int checkItem = mMap.getMapType() - 1;

        // Add an OnClickListener to the dialog, so that the selection will be handled.
        builder.setSingleChoiceItems(
                MAP_TYPE_ITEMS,
                checkItem,
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int item) {
                        // Locally create a finalised object.

                        // Perform an action depending on which item was selected.
                        switch (item) {
                            case 1:
                                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                                break;
                            case 2:
                                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                                break;
                            case 3:
                                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                                break;
                            default:
                                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                        }
                        dialog.dismiss();
                    }
                }
        );

        // Build the dialog and show it.
        AlertDialog fMapTypeDialog = builder.create();
        fMapTypeDialog.setCanceledOnTouchOutside(true);
        fMapTypeDialog.show();
    }


}
