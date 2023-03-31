package it.softwareinside.app.models;

import java.util.Random;

import lombok.Data;

@Data
public class Enemy {
	private int puntiVita;
	private boolean isAlive;
	private String nome;

	public Enemy() {
		this("Shrek", 30);
	}

	public Enemy(String nome, int puntiVita) {
		setPuntiVita(puntiVita);
		setNome(nome);
		isAlive = true;
	}

	public int attacca() {
		Random random = new Random();
		int danno = random.nextInt(2, 7);

		return danno;
	}

	public int attacca(Eroe eroe) {
		Random random = new Random();
		int danno = random.nextInt(5, 15);

		eroe.prendiDanno(danno);

		return danno;
	}

	public void prendiDanno(int danno) {
		setPuntiVita(getPuntiVita() - danno);
		if (getPuntiVita() <= 0)
			setAlive(false);
	}
}
