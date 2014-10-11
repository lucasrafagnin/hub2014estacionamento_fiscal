package com.mmidgard.hubestacionamento.dao;

import android.content.Context;

import com.mmidgard.hubestacionamento.models.Estacionamento;

public class EstacionamentoDAO extends GenericDAO<Estacionamento> {

	public EstacionamentoDAO(Context context) {
		super(context, Estacionamento.class);
	}
}
