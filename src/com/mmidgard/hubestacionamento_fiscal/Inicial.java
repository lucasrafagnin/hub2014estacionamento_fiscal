package com.mmidgard.hubestacionamento_fiscal;

import internet.ServiceError;
import internet.WSClient;

import java.util.ArrayList;
import java.util.List;

import models.Statuss;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.mmidgard.hubestacionamento_fiscal.dao.CarroDAO;
import com.mmidgard.hubestacionamento_fiscal.models.Carro;

public class Inicial extends Activity {

	private AdapterListExercicios adapterExercicios;
	private ListView listViewExercicios;
	private List<Carro> listaCarros;
	private Button buscar;
	private Button atualizar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.inicial);

		Config.configSenha();
		listaCarros = new ArrayList<Carro>();
		atualizarLista();

		buscar = (Button)findViewById(R.id.buscar);
		atualizar = (Button)findViewById(R.id.atualizar);

		atualizar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				buscarTodosStatus();
			}
		});

		buscar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				EditText placa1 = (EditText)findViewById(R.id.placa1);
				EditText placa2 = (EditText)findViewById(R.id.placa2);

				String sPlaca1 = placa1.getText().toString();
				String sPlaca2 = placa2.getText().toString();

				if (sPlaca1.length() == 3 && sPlaca2.length() == 4) {
					final String buscar = sPlaca1 + "" + sPlaca2;
					boolean continuar = true;
					for (Carro c : listaCarros) {
						if (c.getPlaca().equals(buscar))
							continuar = false;
					}
					if (continuar) {
						new AsyncTask<Void, Void, String>() {
							@Override
							protected String doInBackground(Void... params) {
								Statuss s;
								try {
									s = WSClient.consultaCarro(buscar);
									if (s.status)
										return "Placa com créditos";
									else
										return "Placa sem créditos";
								} catch (ServiceError e) {
									e.printStackTrace();
									return "Placa não encontrada";
								}
							}

							@Override
							protected void onPostExecute(String result) {
								super.onPostExecute(result);
								if (result.equals("Placa com créditos"))
									adicionarCarro(buscar, true);
								else if (result.equals("Placa sem créditos"))
									adicionarCarro(buscar, false);
								Toast.makeText(Inicial.this, result, Toast.LENGTH_SHORT).show();
							}
						}.execute();
					} else {
						Toast.makeText(Inicial.this, "Esta placa ja esta cadastrada", Toast.LENGTH_SHORT).show();
					}
				} else {
					Toast.makeText(Inicial.this, "Digite a placa corretamente", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	private void atualizarLista() {
		listaCarros = new CarroDAO(Inicial.this).getAll();
		adapterExercicios = new AdapterListExercicios(this, listaCarros);

		listViewExercicios = (ListView)findViewById(R.id.list_carros);
		listViewExercicios.setAdapter(adapterExercicios);
	}

	private void adicionarCarro(String placa, boolean status) {
		CarroDAO cdao = new CarroDAO(Inicial.this);
		Carro c = new Carro(placa, status);
		cdao.insert(c);

		atualizarLista();
	}

	public void buscarTodosStatus() {
		new AsyncTask<Void, Void, String>() {
			@Override
			protected String doInBackground(Void... params) {
				Statuss s;
				CarroDAO cdao = new CarroDAO(Inicial.this);
				List<Carro> cars = cdao.getAll();
				try {
					for (Carro c : cars) {
						s = WSClient.consultaCarro(c.getPlaca());
						c.setStatus(s.status);
						cdao.update(c);
					}
				} catch (ServiceError e) {
					e.printStackTrace();
					return "Erro ao buscar/atualizar placas";
				}
				return "Placas atualizadas com sucesso";
			}

			@Override
			protected void onPostExecute(String result) {
				super.onPostExecute(result);
				Toast.makeText(Inicial.this, result, Toast.LENGTH_SHORT).show();
				atualizarLista();
			}
		}.execute();

	}
}
