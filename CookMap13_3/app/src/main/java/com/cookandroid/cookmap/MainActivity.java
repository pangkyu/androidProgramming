package com.cookandroid.cookmap;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap gMap;
    MapFragment mapFrag;
    GroundOverlayOptions videoMark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.googlemap_icon);

        setTitle("Google 지도 활용");

        mapFrag = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFrag.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        gMap = map;
        gMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.568256, 126.897240), 15));
        gMap.getUiSettings().setZoomControlsEnabled(true);
        gMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng point) {
                videoMark = new GroundOverlayOptions().image(
                        BitmapDescriptorFactory
                                .fromResource(R.drawable.rate_star_small_on))
                        .position(point, 100f, 100f);
                gMap.addGroundOverlay(videoMark);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, "위성 지도");
        menu.add(0, 2, 0, "일반 지도");
        menu.add(0, 3, 0, "월드컵경기장 바로가기");
        SubMenu fmspot = menu.addSubMenu("유명장소 바로가기 >> ");
        fmspot.add(0,4,0,"한신대학교 60주년기념관");
        fmspot.add(0,5,0,"병점역");
        fmspot.add(0,6,0,"체이스센터");


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                gMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                return true;
            case 2:
                gMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;
            case 3:
                gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(
                        37.568256, 126.897240), 15));
                return true;
            case 4:
                gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(
                        37.19259, 127.02743), 15));
                return true;
            case 5:
                gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(
                        37.20732, 127.03317), 15));
                return true;
            case 6:
                gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(
                        37.77025, -122.38800), 15));
                return true;
        }
        return false;
    }
}
