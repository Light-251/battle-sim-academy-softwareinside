package it.softwareinside.app.models;

import lombok.Data;

@Data
public class World {
	private Cavaliere cavaliere;
	private Mago mago;
	private Dragone dragone;
	private Orco orco;
	
	public void combattimentoA2(Enemy enemy, Eroe eroe) {
		
	}

}
