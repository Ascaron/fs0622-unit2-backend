package it.epicode.es1d3w1m1;

public class Main {

	public static void main(String[] args) {

		pariDispari("Parallelepipedo");
		annoBisestile(1600);
	}

	static void pariDispari(String stringa) {

		if ((stringa.length() % 2) == 0) {
			System.out.println("true");
			System.out.println(stringa.length());
		} else {
			System.out.println("false");
			System.out.println(stringa.length());
		}
	}

	static void annoBisestile(int anno) {

		if (anno % 100 == 0) {
			if (anno % 400 == 0) {
				System.out.println("true");
			}
			else {
				System.out.println("false");
			}
		} else if (anno % 4 == 0) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
}
