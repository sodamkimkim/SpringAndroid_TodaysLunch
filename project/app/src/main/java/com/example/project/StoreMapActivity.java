package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.project.service.Service;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class StoreMapActivity extends AppCompatActivity implements OnMapReadyCallback {
    private Service service;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;
//        http://map.esran.com/
        LatLng KoreaIT = new LatLng(35.15244376458272, 129.0596193518293);
        LatLng Horaeng = new LatLng(35.154122400633156, 129.06013623509511);
        LatLng HongKongBanJum = new LatLng(35.15520353692448, 129.06134306301288);
        LatLng KimGanae = new LatLng(35.153490570122884, 129.05860610379983);


        MarkerOptions markerOptions1 = new MarkerOptions();
        MarkerOptions markerOptions2 = new MarkerOptions();
        MarkerOptions markerOptions3 = new MarkerOptions();
        MarkerOptions markerOptions4 = new MarkerOptions();


        markerOptions1.position(KoreaIT);
        markerOptions1.title("KoreaIT");
        markerOptions1.snippet("학원");
        mMap.addMarker(markerOptions1);

        markerOptions2.position(Horaeng);
        markerOptions2.title("호랭이밀면");
        markerOptions2.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
//        makerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
        mMap.addMarker(markerOptions2);

        markerOptions3.position(HongKongBanJum);
        markerOptions3.title("홍콩반점");
        markerOptions3.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        mMap.addMarker(markerOptions3);

        markerOptions4.position(KimGanae);
        markerOptions4.title("김가네김밥");
        markerOptions4.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        mMap.addMarker(markerOptions4);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(KoreaIT));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

    }


}