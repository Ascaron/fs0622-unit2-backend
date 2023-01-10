/**
 * 
 */
package it.epicode.be;

import java.util.Scanner;

public class Esercizio4 {


	public static void main(String[] args) {
		System.out.println("Inserisci una parola poi premi Invio");
		Scanner scanner=new Scanner(System.in);
		String parola1= scanner.nextLine();
		System.out.println("Inserisci una parola poi premi Invio");
		String parola2= scanner.nextLine();
		System.out.println("Inserisci una parola poi premi Invio");
		String parola3= scanner.nextLine();
		System.out.println("Hai digitato "+parola1+" "+parola2+" "+parola3);
		System.out.println("Al contrario "+parola3+" "+parola2+" "+parola1);
	}

}
