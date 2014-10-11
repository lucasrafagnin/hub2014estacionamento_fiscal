package com.mmidgard.hubestacionamento.dao;

import android.content.Context;

import com.mmidgard.hubestacionamento.models.Carro;

public class CarroDAO extends GenericDAO<Carro>{

	public CarroDAO(Context context) {
		super(context, Carro.class);
	}
}
