package it.epicode.progsettm1w1be;

public class Audio extends ElementoMultimediale {


	public Audio(String titolo, int durata, int volume) {
		super(titolo, durata, volume);
	}

	public int abbassaVolume() {
		volume--;
		return volume;
	}

	public int alzaVolume() {
		volume++;
		return volume;
	}

}
