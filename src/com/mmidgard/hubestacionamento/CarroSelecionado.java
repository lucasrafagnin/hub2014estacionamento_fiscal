package com.mmidgard.hubestacionamento;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;

public class CarroSelecionado extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.carro_selecionado);

		MapFragment mapFragment = (MapFragment)getFragmentManager().findFragmentById(R.id.map);
		GoogleMap map = mapFragment.getMap();

		map.setMyLocationEnabled(true);

		GPSTracker tracker = new GPSTracker(this);
		if (tracker.canGetLocation() == false) {
			tracker.showSettingsAlert();
		} else {
			double latitude = tracker.getLatitude();
			double longitude = tracker.getLongitude();

			map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude), map.getMaxZoomLevel() - 5));
		}

	}
}
