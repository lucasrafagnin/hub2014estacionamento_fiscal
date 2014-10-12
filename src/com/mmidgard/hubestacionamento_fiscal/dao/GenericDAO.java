package com.mmidgard.hubestacionamento_fiscal.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.QueryBuilder;

public abstract class GenericDAO<E> extends BDControle<E> {

	protected Dao<E, Integer> dao;
	private Class<E> type;

	public GenericDAO(Context context, Class<E> type) {
		super(context);
		this.type = type;
		setDao();
	}

	protected void setDao() {
		try {
			dao = DaoManager.createDao(getConnectionSource(), type);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<E> getAll() {
		List<E> lista = new ArrayList<E>();
		try {
			lista = dao.queryForAll();
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public E getById(int id) {
		try {
			E obj = dao.queryForId(id);
			return obj;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int insert(E obj) {
		try {
			return dao.create(obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void delete(E obj) {
		try {
			dao.delete(obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(E obj) {
		try {
			dao.update(obj);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<E> getValor(String valor, String campo) {
		List<E> lista = new ArrayList<E>();
		try {
			QueryBuilder<E, Integer> queryBuilder = dao.queryBuilder();
			queryBuilder.where().eq(campo, valor);
			lista = dao.query(queryBuilder.prepare());
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
