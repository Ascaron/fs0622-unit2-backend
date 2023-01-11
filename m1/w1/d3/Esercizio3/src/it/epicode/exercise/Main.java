package it.epicode.exercise;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("Inserisci una parola e poi premi invio");
		Scanner scanner=new Scanner(System.in);
		String parola= scanner.nextLine();
		
		int i=0;
		String valoreErrato=":q";
		do{
			System.out.print(parola.charAt(i) + ",");
			i++;
		}
		while(!parola.equals(valoreErrato) && i<parola.length());

	}

}
