package com.mmidgard.hubestacionamento.dao;

import android.content.Context;

import com.mmidgard.hubestacionamento.models.Recarga;

public class RecargaDAO extends GenericDAO<Recarga> {

	public RecargaDAO(Context context) {
		super(context, Recarga.class);
	}
}
