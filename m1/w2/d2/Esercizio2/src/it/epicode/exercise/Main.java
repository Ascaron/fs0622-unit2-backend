package it.epicode.exercise;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<Integer> lista = new ArrayList<>();
		List<Integer> lista2 = new ArrayList<>();
		List<Integer> lista3 = new ArrayList<>();
		List<Integer> listaPari = new ArrayList<>();
		List<Integer> listaDispari = new ArrayList<>();

		System.out.println("Inserisci un numero");
		Scanner scanner = new Scanner(System.in);
		int numero = scanner.nextInt();
		for (int i = 0; i < numero; i++) {
			int valore = (int) Math.floor(Math.random() * 100 + 1);
			lista.add(i, valore);
		}
		System.out.println(lista);
		for (int i = 0; i < lista.size(); i++) {
			lista2.add(i, lista.get(lista.size() - (i + 1)));
		}
		lista3.addAll(lista);
		lista3.addAll(lista2);
		System.out.println(lista3);

		for (int i = 0; i < lista3.size(); i++) {
			if (i%2 == 0) {
				listaPari.add(lista3.get(i));
			} else {
				listaDispari.add(lista3.get(i));
			}
		}
		System.out.println("Vuoi vedere pari o dispari?");
		String scelta = scanner.next();
		if (scelta.equals("pari")) {
			System.out.println(listaPari);
		}
		else {
			System.out.println(listaDispari);
		}
		scanner.close();
	}

}
