package it.softwareinside.app.models;

public class Orco extends Enemy {

	public Orco(String nome, int puntiVita) {
		super(nome, puntiVita);
		System.out.println(this.getNome() + " si fa strada nell'arena");
	}

	public Orco() {
		this("Orco generico", 100);
	}

	@Override
	public void prendiDanno(int danno) {
		super.prendiDanno(danno);
		//System.out.println("La vita di Orco si riduce di " + danno + " ora ha " + getPuntiVita() + " punti vita");
	}

	@Override
	public int attacca(Eroe eroe) {
		int danno = super.attacca(eroe);
		System.out.println(this.getNome() + " attacca " + eroe.getNome() + " (" + danno + " danni)");

		return danno;
	}

}
