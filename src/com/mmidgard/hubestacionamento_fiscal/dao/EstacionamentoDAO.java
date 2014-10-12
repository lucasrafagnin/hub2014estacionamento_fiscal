package com.mmidgard.hubestacionamento_fiscal.dao;

import android.content.Context;

import com.mmidgard.hubestacionamento_fiscal.models.Estacionamento;

public class EstacionamentoDAO extends GenericDAO<Estacionamento> {

	public EstacionamentoDAO(Context context) {
		super(context, Estacionamento.class);
	}
}
