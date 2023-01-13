package it.epicode.progsettm1w1be;

import java.util.Scanner;

public class LettoreMultimediale implements Funzionamento{

	public static void main(String[] args) {

		System.out.printf("Ciao, sono il tuo nuovo lettore multimediale!!! %nScegli 5 file da salvare.%n");
		lanciaDispositivo();

	}

	public static void lanciaDispositivo() {
		Object[][] arrayEl= new Object[5][4];
		for (int i = 0; i <= 4; i++) {
			System.out.println("Quale formato fra audio video immagine ha l'elemento, scrivilo e premi invio!!!");
			Scanner scanner = new Scanner(System.in);
			String file = scanner.nextLine();

			switch (file) {

			case "audio":
				System.out.println("Titolo?");
				String titoloAudio = scanner.nextLine();
				System.out.println("Quanti secondi dura il tuo audio (max 10 secondi)?");
				int durataAudio = scanner.nextInt();
				System.out.println("Imposta un volume da 1 a 5 e premi invio");
				int volumeAudio = scanner.nextInt();
				Audio fileAudio = new Audio(titoloAudio, durataAudio, volumeAudio);
				fileAudio.setDurata(durataAudio);
				fileAudio.setVolume(volumeAudio);
				arrayEl[i][0]=fileAudio.getTitolo();
				arrayEl[i][1]=fileAudio.getDurata();
				arrayEl[i][2]=fileAudio.getVolume();
				arrayEl[i][3]="";
				break;

			case "video":
				System.out.println("Titolo?");
				String titoloVideo = scanner.nextLine();
				System.out.println("Quanti secondi dura il tuo video (max 10 secondi)?");
				int durataVideo = scanner.nextInt();
				System.out.println("Imposta un volume da 1 a 5 e premi invio");
				int volumeVideo = scanner.nextInt();
				System.out.println("Imposta luminosità da 1 a 5 e premi invio");
				int luminositaVideo = scanner.nextInt();
				Video fileVideo = new Video(titoloVideo, durataVideo, volumeVideo, luminositaVideo);
				fileVideo.setDurata(durataVideo);
				fileVideo.setVolume(volumeVideo);
				fileVideo.setLuminosita(luminositaVideo);
				arrayEl[i][0]=fileVideo.getTitolo();
				arrayEl[i][1]=fileVideo.getDurata();
				arrayEl[i][2]=fileVideo.getVolume();
				arrayEl[i][3]=fileVideo.getLuminosita();
				break;

			case "immagine":
				System.out.println("Titolo?");
				String titoloImm = scanner.nextLine();
				System.out.println("Imposta luminosità da 1 a 5 e premi invio");
				int luminositaImm = scanner.nextInt();
				Immagine fileImm = new Immagine(titoloImm, luminositaImm);
				fileImm.setLuminosita(luminositaImm);
				arrayEl[i][0]=fileImm.getTitolo();
				arrayEl[i][1]="";
				arrayEl[i][2]="";
				arrayEl[i][3]=fileImm.getLuminosita();
				break;

			default:
				System.out.println("Scegli un file!");
				break;
			}
		}
		System.out.println("Quale file vuoi riprodurre? Selezionali inserendo un numero da 1 a 5, oppure premi 0 per spegnermi");
		Scanner scanner = new Scanner(System.in);
		int scelta = scanner.nextInt();
		
		switch(scelta) {
		
		case 1:
			if(arrayEl[0][2].equals("")) {
				System.out.println(arrayEl[0][0]+" "+ arrayEl[0][3]);
			}
			else {
				if(arrayEl[0][3].equals("")) {
					System.out.println(arrayEl[0][0]+" "+ arrayEl[0][2]);
					}
				else {
					System.out.println(arrayEl[0][0]+" "+ arrayEl[0][2]+" "+arrayEl[0][3]);
				}
			}
			
		case 2:
			if(arrayEl[1][2].equals("")) {
				System.out.println(arrayEl[1][0]+" "+ arrayEl[1][3]);
			}
			else {
				if(arrayEl[1][3].equals("")) {
					System.out.println(arrayEl[1][0]+" "+ arrayEl[1][2]);
				}
				else {
					System.out.println(arrayEl[1][0]+" "+ arrayEl[1][2]+" "+arrayEl[1][3]);
				}
			}
			break;
			
		case 3:
			if(arrayEl[2][2].equals("")) {
				System.out.println(arrayEl[2][0]+" "+ arrayEl[2][3]);
			}
			else {
				if(arrayEl[2][3].equals("")) {
					System.out.println(arrayEl[2][0]+" "+ arrayEl[2][2]);
				}
				else {
					System.out.println(arrayEl[2][0]+" "+ arrayEl[2][2]+" "+arrayEl[2][3]);
				}
			}
			break;
			
		case 4:
			if(arrayEl[3][2].equals("")) {
				System.out.println(arrayEl[3][0]+" "+ arrayEl[3][3]);
			}
			else {
				if(arrayEl[3][3].equals("")) {
					System.out.println(arrayEl[3][0]+" "+ arrayEl[3][2]);
				}
				else {
					System.out.println(arrayEl[3][0]+" "+ arrayEl[3][2]+" "+arrayEl[3][3]);
				}
			}
			break;
			
		case 5:
			if(arrayEl[4][2].equals("")) {
				System.out.println(arrayEl[4][0]+" "+ arrayEl[4][3]);
			}
			else {
				if(arrayEl[4][3].equals("")) {
					System.out.println(arrayEl[4][0]+" "+ arrayEl[4][2]);
				}
				else {
					System.out.println(arrayEl[4][0]+" "+ arrayEl[4][2]+" "+arrayEl[4][3]);
				}
			}
			break;
			
		case 0:
			System.out.println("CIAO");
			break;
		}
		scanner.close();
	}
	

	public void play(){
		
	}
	
	public void show() {
		
	}
}
