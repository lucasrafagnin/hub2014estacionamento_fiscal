package com.mmidgard.hubestacionamento_fiscal.dao;

import android.content.Context;

import com.mmidgard.hubestacionamento_fiscal.models.Motorista;

public class MotoristaDAO extends GenericDAO<Motorista>{

	public MotoristaDAO(Context context) {
		super(context, Motorista.class);
	}
}
