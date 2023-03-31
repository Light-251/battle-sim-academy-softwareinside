package it.softwareinside.app.models;

import java.util.ArrayList;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Cavaliere extends Eroe {
	private final int DIMENSIONE_FARETRA = 3;
	private Cavallo cavallo;
	private ArrayList<Freccia> faretra;

	public Cavaliere() {
		this("Cavaliere sconosciuto", 2, 20, new Cavallo());
		riempiFaretra();

	}

	public Cavaliere(String nome, int puntiAttacco, int puntiVita, Cavallo cavallo) {
		super(nome, puntiAttacco, puntiVita);
		setCavallo(cavallo);
		setFaretra(new ArrayList<Freccia>());
		riempiFaretra();
		System.out.println(getNome() + " scende in campo");
	}

	public void aggiungiFreccia(Freccia freccia) {
		if (getFaretra().size() < DIMENSIONE_FARETRA) {
			getFaretra().add(freccia);
//			System.out.println("Aggiunta freccia " + freccia);
		}
	}

	/**
	 * Riempie la faretra di freccie standard (legno leggero)
	 */
	public void riempiFaretra() {
		for (int i = 0; getFaretra().size() < getDIMENSIONE_FARETRA(); i++) {
			aggiungiFreccia(new Freccia());
		}
	}

	/**
	 * Riempie la faretra di freccie come quella presa in ingresso
	 */
	public void riempiFaretra(Freccia freccia) {
		for (int i = 0; i < getDIMENSIONE_FARETRA(); i++)
			aggiungiFreccia(freccia);

	}

	public boolean aggiungiCavallo(Cavallo cavallo) {
		if (getCavallo() == null) {
			setCavallo(cavallo);
			System.out.println(this.getNome() + " ora cavalca " + cavallo.getNome());
			return true;
		}
		System.out.println(this.getNome() + " ha già un cavallo");
		return false;
	}

	public void rimuoviCavallo() {
		if (getCavallo() != null) {
			System.out.println(this.getNome() + " ha lasciato " + getCavallo().getNome());
			setCavallo(null);
		} else
			System.out.println(this.getNome() + " non possiede un cavallo");

	}

	public int attaccoConSpada(Enemy enemy) {// inserire target
		System.out.print(getNome() + " prova ad attaccare con la spada,");

		if (getRandom().nextInt(0, 100) > 5 /* <-- cambiare con agilità nemico */) {
			int danno = getPuntiAttacco() + generaAttacco(7, 10);
			System.out.println(" colpisce " + enemy.getNome() + " (" + danno + " danni)");
			return danno;
		}
		System.out.println(" ma non colpisce");
		return 0;

	}

	public int attaccoConArco(Enemy enemy) {
		System.out.print(this.getNome() + " prova a scoccare una freccia, ");
		if (faretra.size() > 0) {
			int danno = faretra.get(0).getDannoFreccia() + generaAttacco(6, 12);
			faretra.remove(0);
			System.out.println("colpisce " + enemy.getNome() + " (" + danno + " danni), rimangono "
					+ getFaretra().size() + " frecce");
			return danno;
		}
		System.out.println("ma non ha più frecce");
		return 0;

	}

	public int attaccoConCavallo(Enemy enemy) {
		if (getCavallo() != null) {
			int danni = generaAttacco(7, 10);
			System.out.print(this.getNome() + " attacca " + enemy.getNome() + " in sella a " + getCavallo().getNome());
			System.out.println(" (" + danni + " danni)");
			return danni;
		} else {
			System.out.println(getNome() + " non ha un cavallo");
			return 0;
		}

	}

}
