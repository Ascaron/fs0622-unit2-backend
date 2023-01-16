package it.epicode.exercise;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		calcolaConsumi();
	}

	public static void calcolaConsumi() {
		System.out.println("Quanti km percorrerai?");
		Scanner scanner=new Scanner(System.in);
		int km= scanner.nextInt();
		System.out.println("Quanti litri di carburante hai?");
		int litri= scanner.nextInt();
		try {
			int consumi= km/litri;
			System.out.println("La tua auto percorre "+consumi+" km con un litro");
		}
		catch(ArithmeticException e) {
			System.out.println("Inserisci un reale numero di litri");
		}
		scanner.close();
		
	}
}
