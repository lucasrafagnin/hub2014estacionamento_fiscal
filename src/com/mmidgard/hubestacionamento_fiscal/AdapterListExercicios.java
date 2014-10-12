package com.mmidgard.hubestacionamento_fiscal;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mmidgard.hubestacionamento_fiscal.dao.CarroDAO;
import com.mmidgard.hubestacionamento_fiscal.models.Carro;

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
		TextView placa = (TextView)viewItem.findViewById(R.id.carro_placa);
		ImageButton deletar = (ImageButton)viewItem.findViewById(R.id.deletar);

		deletar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				CarroDAO cdao = new CarroDAO(context);
				cdao.delete(carro);
				Toast.makeText(context, "Deletado com sucesso", Toast.LENGTH_SHORT).show();
				listaCarros.remove(carro);
				notifyDataSetChanged();
			}
		});

		if (carro.isStatus())
			status.setImageResource(R.drawable.yes);
		else
			status.setImageResource(R.drawable.no);
		placa.setText(carro.getPlaca());

		return viewItem;
	}

}
