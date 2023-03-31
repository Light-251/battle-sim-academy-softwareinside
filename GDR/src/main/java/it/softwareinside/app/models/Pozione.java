package it.softwareinside.app.models;

import lombok.Data;

@Data
public class Pozione {

	private int quantitaVitaRecuperata;

	public Pozione() {
		this(20);
	}

	public Pozione(int quantitaVitaRecuperata) {
		setQuantitaVitaRecuperata(quantitaVitaRecuperata);
	}

}
