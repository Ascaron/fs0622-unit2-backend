package it.epicode.be;

import java.util.Arrays;

public class Helloworld {

public static void main (String[] args)
		{
	String[] array=new String[5];
		array[0]="Uno";
		array[1]="Due";
		array[2]="Quattro";
		array[3]="Cinque";
		array[4]="Sei";
		// Stampa a console  la frase
		System.out.println("This is my first Epicode Java Project!");
		System.out.println(Moltiplica(5,10));
		System.out.println(Concatena("Amilcare",10));
		System.out.println(InserisciInArray(array,"Tre"));
		}
		
		//metodo1
		static int Moltiplica(int a, int b) {
			int c= a*b;
			return c;
			}
		
		//metodo2
		static String Concatena(String nome, int d) {
		String frase=nome+" "+d;
		return frase;
		}
		
		//metodo3
		static String InserisciInArray(String[] Elementi, String e ) {
			String[] ElementiFinali=new String[6];
			ElementiFinali[0]= Elementi[0];
			ElementiFinali[1]= Elementi[1];
			ElementiFinali[2]= e;
			ElementiFinali[3]= Elementi[2];
			ElementiFinali[4]= Elementi[3];
			ElementiFinali[5]= Elementi[4];
			return Arrays.toString(ElementiFinali);
		}

}