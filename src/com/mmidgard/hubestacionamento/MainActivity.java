package com.mmidgard.hubestacionamento;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.mmidgard.hubestacionamento.models.Carro;

public class MainActivity extends Activity implements OnItemClickListener {

	private AdapterListExercicios<Carro> adapterExercicios;
	private ListView listViewExercicios;
	private List<Carro> listaCarros;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inicial);

		
		criarLista(listaCarros);
	}

	private void criarLista(List<Carro> elementList) {
		adapterExercicios = new AdapterListExercicios<Carro>(this, listaCarros);

		listViewExercicios = (ListView)findViewById(R.id.list_carros);
		listViewExercicios.setAdapter(adapterExercicios);
		listViewExercicios.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

	}
}
