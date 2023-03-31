package it.softwareinside.app.models;

import java.util.Random;

import lombok.Data;

@Data
public class Eroe {
	private final int MAX_VITA = 99999;

	private Random random;
	private int puntiAttacco;
	private int puntiVita;
	private boolean isAlive;
	private String nome;

	public Eroe() {
		this("Eroe Sconosciuto", 2, 20);

	}

	public Eroe(String nome, int puntiAttacco, int puntiVita) {
		setNome(nome);
		setPuntiAttacco(puntiAttacco);
		setPuntiVita(puntiVita);
		setAlive(true);
		setRandom(new Random());
	}

	public void setPuntiVita(int puntiVita) {
		this.puntiVita = puntiVita > MAX_VITA ? MAX_VITA : puntiVita;
	}

	public int generaAttacco(int low, int upper) {
		setPuntiAttacco(getRandom().nextInt(low, upper));
		return getPuntiAttacco();
	}

	public void prendiDanno(int danno) {
		setPuntiVita(getPuntiVita() - danno);
		if (getPuntiVita() <= 0)
			setAlive(false);

//		if (danno > 0 && this.isAlive())
//			System.out.println("La vita di " + this.getNome() + " si riduce di " + danno + " ora ha " + this.getPuntiVita() + " punti vita");
	}

}
