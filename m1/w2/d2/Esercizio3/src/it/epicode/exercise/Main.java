package it.epicode.exercise;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		HashMap<String, Integer> rubrica = new HashMap<>();
		System.out.println("Hai posto per 5 contatti");
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			System.out.println("Inserisci il nome");
			String nome = scanner.next();
			System.out.println("Inserisci un numero");
			int numero = scanner.nextInt();
			rubrica.put(nome, numero);
		}
		System.out.println(rubrica);
		System.out.println("Vuoi cancellare un contatto? Digita il nome");
		String cancella = scanner.next();
		rubrica.remove(cancella);
		System.out.println(rubrica);
		System.out.println("Che numero vuoi trovare?");
		int contatto=scanner.nextInt();
		for(HashMap.Entry<String, Integer> numeri: rubrica.entrySet()) {
			if(Objects.equals(contatto, numeri.getValue())) {
				System.out.println(numeri.getKey());
			}
		}
		System.out.println("Chi vuoi trovare?");
		String persona = scanner.next();
		System.out.println(rubrica.get(persona));
		System.out.println(rubrica);
		scanner.close();
		
	}

}
