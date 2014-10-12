package com.mmidgard.hubestacionamento_fiscal.dao;

import android.content.Context;

import com.mmidgard.hubestacionamento_fiscal.models.Recarga;

public class RecargaDAO extends GenericDAO<Recarga> {

	public RecargaDAO(Context context) {
		super(context, Recarga.class);
	}
}
