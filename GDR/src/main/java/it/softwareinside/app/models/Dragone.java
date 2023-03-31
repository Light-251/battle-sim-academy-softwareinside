package it.softwareinside.app.models;

import java.util.Random;

public class Dragone extends Enemy {

	public Dragone(String nome, int puntiVita) {
		super(nome, puntiVita);
		System.out.println(this.getNome() + " atterra in campo");
	}

	@Override
	public void prendiDanno(int danno) {
		super.prendiDanno(danno);
		// if (danno > 0 && this.isAlive())
//		System.out.println("La vita di Dragone si riduce di " + danno + " ora ha " + getPuntiVita() + " punti vita");
	}

	public void soffioDiFuoco(Eroe eroe) {
		Random random = new Random();
		int danni = random.nextInt(7, 15);
		eroe.prendiDanno(danni);
		System.out.println(this.getNome() + " soffia fuoco in faccia a " + eroe.getNome() + " (" + danni + " danni)");
	}

}
