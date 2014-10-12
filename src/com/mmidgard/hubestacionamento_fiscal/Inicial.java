package com.mmidgard.hubestacionamento_fiscal;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;

import com.mmidgard.hubestacionamento_fiscal.models.Carro;

public class Inicial extends GlobalActivity {

	private AdapterListExercicios adapterExercicios;
	private ListView listViewExercicios;
	private List<Carro> listaCarros;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.inicial);

		// header();

		listaCarros = new ArrayList<Carro>();
		criarLista(listaCarros);

		adicionarRecarga();
	}

	// private void criarCarrosTeste() {
	// Carro c = new Carro("abc-1234", "gol branco", true);
	// Carro c2 = new Carro("abc-1234", "gol branco", true);
	// Carro c3 = new Carro("abc-1234", "gol branco", true);
	// Carro c4 = new Carro("abc-1234", "gol branco", true);
	//
	// listaCarros.add(c);
	// listaCarros.add(c2);
	// listaCarros.add(c3);
	// listaCarros.add(c4);
	// }

	private void criarLista(List<Carro> elementList) {
		adapterExercicios = new AdapterListExercicios(this, listaCarros);

		listViewExercicios = (ListView)findViewById(R.id.list_carros);
		listViewExercicios.setAdapter(adapterExercicios);
	}
}
