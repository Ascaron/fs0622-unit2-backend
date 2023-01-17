package it.epicode.exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		HashSet<String> hset= new HashSet<>();
		ArrayList<String> doppioni=new ArrayList<>();
		int contatoreDis=0;

		System.out.println("Inserisci un numero");
		Scanner scanner=new Scanner(System.in);
		int numero=scanner.nextInt();
		for(int i=1; i<=numero; i++) {
			System.out.println("Inserisci una parola");
			String parola=scanner.next();
			if(hset.contains(parola)) {
				doppioni.add(parola);
			}
			else {
				hset.add(parola);
				contatoreDis++;
			}
		}
		scanner.close();
		System.out.println("Parole reinserite: "+ doppioni);
		System.out.println("Numero parole distinte: "+contatoreDis);
		System.out.println("Parole distinte: "+hset);
	}

}
