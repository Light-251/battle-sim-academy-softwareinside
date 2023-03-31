package it.softwareinside.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Freccia {
	private String tipologiaFreccia;
	private int dannoFreccia;
	
	public Freccia() {
		this("freccia di legno leggera", 3);
	}

}
