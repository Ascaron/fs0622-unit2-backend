package it.epicode.esxercise;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int[] arrayN = new int[5];

		for (int i = 0; i < arrayN.length; i++) {
			arrayN[i] = (int) Math.floor(Math.random() * 10 + 1);
			System.out.printf(arrayN[i] + " ");
		}

		int numero = 0;
		do {
			System.out.printf("%nScegli un numero");
			Scanner scanner = new Scanner(System.in);
			numero = scanner.nextInt();
			System.out.printf("%nQuale posizione vuoi cambiare?");
			int selezione = scanner.nextInt();
			if (numero < 1 || numero > 10) {
				System.out.println("Valore non valido");
				// return;
			} else {
				try {
					arrayN[selezione-1] = numero;
				}
				catch(ArrayIndexOutOfBoundsException e){
					System.out.println("Valore non valido");
				}
				for (int i = 0; i < arrayN.length; i++) {
					System.out.printf(arrayN[i] + " ");
				}
				scanner.close();
			}

		} while (numero!= 0);
	}


}
