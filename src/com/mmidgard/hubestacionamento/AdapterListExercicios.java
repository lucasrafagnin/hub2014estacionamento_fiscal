package com.mmidgard.hubestacionamento;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mmidgard.hubestacionamento.models.Carro;

public class AdapterListExercicios extends BaseAdapter {

	private Context context;
	private List<Carro> listaCarros;
	private LayoutInflater mInflater;

	public AdapterListExercicios(Context context, List<Carro> listaCarros) {
		this.context = context;
		this.listaCarros = listaCarros;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return listaCarros.size();
	}

	@Override
	public Object getItem(int posicao) {
		return listaCarros.get(posicao);
	}

	@Override
	public long getItemId(int posicao) {
		return posicao;
	}

	@Override
	public View getView(int posicao, View view, ViewGroup parent) {
		final Carro carro = listaCarros.get(posicao);
		View viewItem = mInflater.inflate(R.layout.carro_item, null);

		ImageView status = (ImageView)viewItem.findViewById(R.id.carro_status);
		TextView nome = (TextView)viewItem.findViewById(R.id.carro_nome);
		TextView placa = (TextView)viewItem.findViewById(R.id.carro_placa);

		status.setImageResource(R.drawable.carro_andando);
		nome.setText(carro.getNome());
		placa.setText(carro.getPlaca());

		return viewItem;
	}

}
