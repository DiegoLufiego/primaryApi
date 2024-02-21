package com.kopek.stockAndSales.dtos;

import lombok.Data;

@Data
public class Dato {

	private Integer id;
	private String cadena;

	public Dato(Integer id, String cadena) {
		super();
		this.id = id;
		this.cadena = cadena;
	}

	public Dato() {
		super();
	}

}
