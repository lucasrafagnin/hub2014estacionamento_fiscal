package com.mmidgard.hubestacionamento_fiscal.dao;

import android.content.Context;

import com.mmidgard.hubestacionamento_fiscal.models.Carro;

public class CarroDAO extends GenericDAO<Carro>{

	public CarroDAO(Context context) {
		super(context, Carro.class);
	}
}
