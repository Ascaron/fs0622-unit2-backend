package it.epicode.exercise;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class Main {
	
	private static final String ENCODING = "utf-8";

	public static void main(String[] args) {
		
		Scanner scanner= new Scanner(System.in);		
		File fileInfo = new File("presenze.txt");
		
		if( fileInfo.exists() ) {
			System.out.printf("Cosa vuoi fare?%nA)-Esci%nB)-Aggiungi utente%nC)-Leggi file%n");
			String scelta= scanner.next();
			switch(scelta) {
			
			case "A":
				break;
			
			case "B":
				System.out.println( "Aggiungi utente: " );
				try {
					System.out.println( "Nome utente:" );
					String nome = scanner.next();
					System.out.println( "Cognome utente:" );
					String cognome = scanner.next();
					System.out.printf("Presenze utente");
					String numPres= scanner.next();
					
					scrivi( fileInfo, nome+" "+cognome+"@"+numPres+"#", true );

					System.out.println( "Ho scritto correttamente sul file!" );
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			case "C":
				System.out.println( "Leggi dal file:" );
				try {
					leggi(fileInfo);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		else {
			System.out.printf( "il file %s non esiste %n", "presenze.txt" );
		}
		
		scanner.close();

	}
	
	public static void scrivi(File f, String s, boolean append) throws IOException {
		FileUtils.writeStringToFile(f, s, ENCODING, append);
	}
	
	public static void leggi(File f) throws IOException {
		System.out.println( FileUtils.readFileToString(f, ENCODING) );
	}

}

/*
 * Realizzare la classe RegistroPresenze che contiene un elenco variabile di
 * presenze. Ogni presenza è composta da un nome del dipendente e da un intero
 * che indica i giorni di presenza. Usando la classe Apache Commons IO FileUtils
 * implementare un metodo di RegistroPresenze che salvi su disco un file con le
 * presenze ed un secondo metodo che legga da disco il file e istanzi in memoria
 * gli oggetti corrispondenti.
 * 
 * Utilizzare un formato simile al seguente per storicizzare i dati su file:
 * 
 * Mario Rossi@5#Giorgio Bianchi@7#Gianni Verdi@7
 */