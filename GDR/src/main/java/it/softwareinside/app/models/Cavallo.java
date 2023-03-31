package it.softwareinside.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cavallo {
	private String nome;
	private String colore;
	
	public Cavallo() {
		this("Ronzino", "marrone");
	}

}
