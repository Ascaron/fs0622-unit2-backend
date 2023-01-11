package it.epicode.exercise;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Inserisci un numero da 1 a 20 e premi Invio");
		Scanner scanner=new Scanner(System.in);
		int intero= scanner.nextInt();
		
		for(int i=intero; i>=0; i--) {
			System.out.print(i+" ");
		}

	}

}
