package com.mmidgard.hubestacionamento.models;

import java.io.Serializable;

public class Carro implements Serializable {

	private static final long serialVersionUID = 4149085837268143831L;

	private int id;
	private String placa;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

}
