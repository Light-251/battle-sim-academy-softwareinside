package it.softwareinside.app.models;

import java.util.Random;

import org.junit.Test;

public class TestGenerici {
	Cavallo epona = new Cavallo("Epona", "marrone");
	Cavaliere cavaliere = new Cavaliere("Link", 1, 130, epona);
	Mago mago = new Mago("Gandalf", 4, 70);
	Orco orco = new Orco("Shrek", 110);
	Dragone dragone = new Dragone("Balerion", 120);

	@Test
	public void test() {

		int attesa = 1, turno = 1;
		boolean deathMessageCavalere = true, deathMessageMago = true, deathMessageOrco = true, deathMessageDrago = true;

		System.out.println("\nINIZIO BATTAGLIA");
		do {
			System.out.println("\nTURNO " + turno + ":");

			try {
				Thread.sleep(1000 * attesa);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// tutti attaccano in un turno
//			azioniCavaliere(cavaliere, dragone.isAlive() ? dragone : orco);
//			azioniOrco(orco, mago.isAlive() ? mago : cavaliere);
//			azioniDragone(dragone, cavaliere.isAlive() ? cavaliere : mago);
//			azioniMago(mago, orco.isAlive() ? orco : dragone, cavaliere);

			// scelta attaccante in questo turno ( 1 per turno)
			sceltaAttaccante();

			if (!orco.isAlive() && deathMessageOrco) {
				System.err.println("\n" + orco.getNome().toUpperCase() + " SI LEVA DI TORNO");
				deathMessageOrco = false;
			}
			if (!cavaliere.isAlive() && deathMessageCavalere) {
				System.err.println("\n" + cavaliere.getNome().toUpperCase() + " LASCIA QUESTO MONDO CRUDELE");
				deathMessageCavalere = false;
			}
			if (!dragone.isAlive() && deathMessageDrago) {
				System.err.println("\n" + dragone.getNome().toUpperCase() + " VOLA NELL'ALTRO MONDO");
				deathMessageDrago = false;
			}
			if (!mago.isAlive() && deathMessageMago) {
				System.err.println("\n" + mago.getNome().toUpperCase() + " TRASCENDE DALLA VITA TERRENA");
				deathMessageMago = false;
			}
			turno++;
		} while ((orco.isAlive() || dragone.isAlive()) && (cavaliere.isAlive() || mago.isAlive()));
		System.out.println("***** GAME OVER *****");
		if (orco.isAlive() || dragone.isAlive())
			System.out.println("I Nemici trionfano, il mondo è nel caos");
		else {
			System.out.println("Gli eroi portano la pace!");
		}
	}

	public void sceltaAttaccante() {
		Random random = new Random();
		int scelta = random.nextInt(0, 81);
		if (scelta <= 20) {
			if (!cavaliere.isAlive())
				azioniMago(mago, orco.isAlive() ? orco : dragone, cavaliere);
			else
				azioniCavaliere(cavaliere, dragone.isAlive() ? dragone : orco);

		} else if (scelta <= 40) {
			if (!orco.isAlive())
				azioniDragone(dragone, cavaliere.isAlive() ? cavaliere : mago);
			else
				azioniOrco(orco, mago.isAlive() ? mago : cavaliere);
		} else if (scelta <= 60)
			if (!dragone.isAlive())
				azioniOrco(orco, mago.isAlive() ? mago : cavaliere);
			else
				azioniDragone(dragone, cavaliere.isAlive() ? cavaliere : mago);
		else {
			if (!mago.isAlive())
				azioniCavaliere(cavaliere, dragone.isAlive() ? dragone : orco);
			else
				azioniMago(mago, orco.isAlive() ? orco : dragone, cavaliere);

		}

	}

	public void azioniCavaliere(Cavaliere cavaliere, Enemy enemy) {
		Random random = new Random();
		int scelta = random.nextInt(1, 5);

		if (enemy.isAlive() && cavaliere.isAlive())
			switch (scelta) {
			case 1:
				enemy.prendiDanno(cavaliere.attaccoConArco(enemy));
				break;
			case 2:
				enemy.prendiDanno(cavaliere.attaccoConSpada(enemy));
				break;
			case 3:
				enemy.prendiDanno(cavaliere.attaccoConCavallo(enemy));
				break;
			default:
				System.out
						.println(cavaliere.getNome() + " si prende un momento per riflettere, il suo attacco aumenta");
				cavaliere.setPuntiAttacco(cavaliere.getPuntiAttacco() + random.nextInt(3, 6));
				break;
			}
	}

	public void azioniOrco(Orco orco, Eroe eroe) {
		if (orco.isAlive() && eroe.isAlive())
			orco.attacca(eroe);
	}

	public void azioniDragone(Dragone dragone, Eroe eroe) {
		if (dragone.isAlive() && eroe.isAlive()) {
			dragone.soffioDiFuoco(eroe);
		}
	}

	public void azioniMago(Mago mago, Enemy enemy, Eroe eroe) {
		Random random = new Random();
		boolean azioneInQuestoTurno = true;

		if (mago.isAlive()) {
			if (mago.getPuntiVita() < 30 && mago.getBorsaPozioni().size() > 0 && azioneInQuestoTurno) {
				mago.recuperaSalute();
				azioneInQuestoTurno = false;
			}
			if (eroe.getPuntiVita() < 30 && mago.getBorsaPozioni().size() > 0 && azioneInQuestoTurno
					&& eroe.isAlive()) {
				mago.curaAlleato(eroe);
				azioneInQuestoTurno = false;
			}

			int sceltaAzione = random.nextInt(1, 7);
			if (azioneInQuestoTurno)
				switch (sceltaAzione) {
				case 5:
					enemy.prendiDanno(mago.folataMagica(enemy));
					break;
				case 6:
					System.out.println(mago.getNome() + " trova una pozione");
					mago.aggiungiPozione(new Pozione());
					break;
				default:
					enemy.prendiDanno(mago.attaccoMagico(enemy));
					break;
				}

		}
	}

}
