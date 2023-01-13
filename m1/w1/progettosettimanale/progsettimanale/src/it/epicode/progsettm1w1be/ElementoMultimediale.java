package it.epicode.progsettm1w1be;

public abstract class ElementoMultimediale {

	private String titolo;
	private int durata;
	protected int volume;
	private int luminosita;

	public ElementoMultimediale(String titolo, int luminosita) {

		this.titolo = titolo;
		this.luminosita = luminosita;
	}

	public ElementoMultimediale(String titolo, int durata, int volume) {

		this(titolo, durata);
		this.volume = volume;
	}

	public ElementoMultimediale(String titolo, int durata, int volume, int luminosita) {

		this(titolo, durata, volume);
		this.luminosita = luminosita;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		if (durata < 1 || durata > 10) {
			System.out.println("Durata non conforme al dispositivo");
			LettoreMultimediale.lanciaDispositivo();
		}
		this.durata = durata;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		if (volume < 1 || volume > 5) {
			System.out.println("Valore volume non impostabile");
			LettoreMultimediale.lanciaDispositivo();
		}
		this.volume = volume;
	}

	public int getLuminosita() {
		return luminosita;
	}

	public void setLuminosita(int luminosita) {
		if (luminosita < 1 || luminosita > 5) {
			System.out.println("Valore luminosità non impostabile");
			LettoreMultimediale.lanciaDispositivo();
		}
		this.luminosita = luminosita;
	}

}
