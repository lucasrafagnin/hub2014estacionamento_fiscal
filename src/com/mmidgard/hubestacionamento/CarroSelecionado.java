package com.mmidgard.hubestacionamento;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.mmidgard.hubestacionamento.models.Carro;

public class CarroSelecionado extends GlobalActivity {

	private Carro carro;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.carro_selecionado);

		Intent i = getIntent();
		Bundle b = i.getExtras();
		carro = (Carro)b.get("carro");
		header();

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
		
		adicionarRecarga();
	}

	private void header() {
		TextView titulo = (TextView)findViewById(R.id.titulo);
		Button add = (Button)findViewById(R.id.add_carro);
		titulo.setText(carro.getPlaca());
		add.setVisibility(View.INVISIBLE);
	}
}
