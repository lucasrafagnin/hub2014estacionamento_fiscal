package com.mmidgard.hubestacionamento.dao;

import android.content.Context;

import com.mmidgard.hubestacionamento.models.Motorista;

public class MotoristaDAO extends GenericDAO<Motorista>{

	public MotoristaDAO(Context context) {
		super(context, Motorista.class);
	}
}
