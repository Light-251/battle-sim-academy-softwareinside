package it.softwareinside.app.models;

import java.util.ArrayList;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Mago extends Eroe implements MagoInteface {
	private final int DIMENSIONE_BORSA_POZIONI = 3;

	private ArrayList<Pozione> borsaPozioni;

	public Mago(String nome, int puntiAttacco, int puntiVita) {
		super(nome, puntiAttacco, puntiVita);
		setBorsaPozioni(new ArrayList<Pozione>());
		System.out.println(this.getNome() + " si materializza in campo");
		riempiPozioni();
	}

	public void riempiPozioni() {
		for (int i = 0; i < DIMENSIONE_BORSA_POZIONI; i++) {
			aggiungiPozione(new Pozione());
		}
	}

	public boolean recuperaSalute() {
		if (getBorsaPozioni().size() > 0) {
			setPuntiVita(getBorsaPozioni().get(0).getQuantitaVitaRecuperata() + getPuntiVita());
			getBorsaPozioni().remove(0);
			System.out.println(this.getNome() + " usa una pozione, la sua vita aumenta a " + this.getPuntiVita());
			return true;
		}
		return false;
	}

	public int folataMagica(Enemy enemy) {
		int danno = 5 + generaAttacco(3, 5);
		System.out.println(this.getNome() + " usa folata magica a " + enemy.getNome() + " (" + danno + " danni)");
		return danno;
	}

	public int attaccoMagico(Enemy enemy) {
		int danno = 2 + generaAttacco(3, 5);
		System.out.println(this.getNome() + " scaglia attacco magico a " + enemy.getNome() + " (" + danno + " danni)");
		return danno;
	}

	public void showPozioni() {
		for (Pozione pozione : borsaPozioni) {
			System.out.println(pozione);
		}

	}

	public boolean curaAlleato(Eroe eroe) {
		if (getBorsaPozioni().size() > 0) {
			int cura = eroe.getPuntiVita() + getBorsaPozioni().get(0).getQuantitaVitaRecuperata();
			eroe.setPuntiVita(cura);
			System.out.println(this.getNome() + " dà una pozione a " + eroe.getNome() + " aumentando la sua vita a "
					+ eroe.getPuntiVita());
			getBorsaPozioni().remove(0);
			return true;
		}
		return false;
	}

	public boolean aggiungiPozione(Pozione pozione) {
		if (getBorsaPozioni().size() < DIMENSIONE_BORSA_POZIONI) {
			getBorsaPozioni().add(pozione);
			return true;
		}
		return false;
	}

}
