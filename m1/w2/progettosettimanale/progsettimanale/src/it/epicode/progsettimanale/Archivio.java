package it.epicode.progsettimanale;

import java.io.File;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;

public class Archivio {

	private static final String ENCODING = "utf-8";

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		File fileLibri = new File("libri.txt");
		File fileRiviste = new File("riviste.txt");

		// AUTORI
		List<Autore> autori = new ArrayList<Autore>();
		Autore autore1 = new Autore("Gesù", "di Nazareth");
		Autore autore2 = new Autore("JRR", "Tolkien");
		Autore autore3 = new Autore("Sun", "Tzu");
		autori.add(autore1);
		autori.add(autore2);
		autori.add(autore3);

		// LIBRI
		List<Libri> libri = new ArrayList<Libri>();
		Libri libro1 = new Libri(12345, "Bibbia", Year.of(0000), 1200, autori.get(0), Genere.RELIGIONE);
		Libri libro2 = new Libri(12346, "Silmarillion", Year.of(1920), 1200, autori.get(1), Genere.FANTASY);
		Libri libro3 = new Libri(12347, "L'arte della guerra", Year.of(0020), 120, autori.get(2), Genere.STORIA);
		libri.add(libro1);
		libri.add(libro2);
		libri.add(libro3);

		// RIVISTE
		List<Riviste> riviste = new ArrayList<Riviste>();
		Riviste rivista1 = new Riviste(12348, "Topolino", Year.of(1950), 100, Periodicita.SETTIMANALE);
		Riviste rivista2 = new Riviste(12349, "Tex", Year.of(1960), 100, Periodicita.MENSILE);
		Riviste rivista3 = new Riviste(92345, "Dragonero", Year.of(2013), 100, Periodicita.MENSILE);
		riviste.add(rivista1);
		riviste.add(rivista2);
		riviste.add(rivista3);

		// PARTE L'APPLICAZIONE

		// SCRIVE RIVISTE E LIBRI ESISTENTI

		pulisciFile(fileLibri, "");
		scriviLibriEsistenti(fileLibri, libri);
		pulisciFile(fileRiviste, "");
		scriviRivisteEsistenti(fileRiviste, riviste);

		// PARTE DI INTERAZIONE
		System.out.println("Benvenuto nell'archivio!");
		System.out.println(" ");
		System.out.println("Cosa vuoi fare?");
		System.out.printf("Premere A per uscire dall' applicazione,%n"
				+ "B per vedere la lista dei libri, C per vedere la lista delle riviste,%n"
				+ "D cerca riviste e libri per codice ISBN, E cerca riviste e libri per anno pubblicazione,%n"
				+ "F cerca libro per autore, G elimina elemento per codice ISBN");
		String scelta = scanner.nextLine();

		switch (scelta) {

		case "A":
			break;

		case "B":
			try {
				leggi(fileLibri);
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		case "C":
			try {
				leggi(fileRiviste);
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		case "D":
			System.out.println("A-Libro B-Rivista");
			String selezione = scanner.nextLine();
			System.out.println(" ");
			if (selezione.equals("A")) {
				System.out.println("Digita codice: ");
				try {
					long codice = scanner.nextLong();
					System.out.println(" ");
					Stream<Libri> libriStream = libri.stream().filter((libro) -> libro.getCodiceISBN() == codice);
					libriStream.forEach(libro -> {
						System.out.println(
								libro.getCodiceISBN() + " - " + libro.getTitolo() + " - " + libro.getAnnoPubblicazione()
										+ " - " + libro.getNumeroPagine() + " - " + libro.getAutore().getNome() + " "
										+ libro.getAutore().getCognome() + " - " + libro.getGenere());
					});
				} catch (InputMismatchException e) {
					System.out.println("Digita un codice esistente");
				}

			} else {
				System.out.println("Digita codice ISBN: ");
				try {
					long codice = scanner.nextLong();
					System.out.println(" ");
					Stream<Riviste> rivisteStream = riviste.stream()
							.filter((rivista) -> rivista.getCodiceISBN() == codice);
					rivisteStream.forEach(rivista -> {
						System.out.println(rivista.getCodiceISBN() + " - " + rivista.getTitolo() + " - "
								+ rivista.getAnnoPubblicazione() + " - " + rivista.getNumeroPagine() + " - "
								+ rivista.getPeriodicita());
					});
				} catch (InputMismatchException e) {
					System.out.println("Digita un codice esistente");
				}

			}
			break;

		case "E":
			System.out.println("A-Libro B-Rivista");
			String selezione2 = scanner.nextLine();
			System.out.println(" ");
			System.out.println(" ");
			if (selezione2.equals("A")) {
				System.out.println("Digita anno in numeri: ");
				int annoInt = scanner.nextInt();
				Year annoY = Year.of(annoInt);
				Stream<Libri> libriStream2 = libri.stream()
						.filter((libro) -> libro.getAnnoPubblicazione().equals(annoY));
				libriStream2.forEach(libro -> {
					System.out.println(
							libro.getCodiceISBN() + " - " + libro.getTitolo() + " - " + libro.getAnnoPubblicazione()
									+ " - " + libro.getNumeroPagine() + " - " + libro.getAutore().getNome() + " "
									+ libro.getAutore().getCognome() + " - " + libro.getGenere());
				});

			} else {
				System.out.println("Digita anno in numeri: ");
				int annoInt = scanner.nextInt();
				System.out.println(" ");
				Year annoY = Year.of(annoInt);
				Stream<Riviste> rivisteStream2 = riviste.stream()
						.filter((rivista) -> rivista.getAnnoPubblicazione().equals(annoY));
				rivisteStream2.forEach(rivista -> {
					System.out.println(rivista.getCodiceISBN() + " - " + rivista.getTitolo() + " - "
							+ rivista.getAnnoPubblicazione() + " - " + rivista.getNumeroPagine() + " - "
							+ rivista.getPeriodicita());
				});
			}
			break;

		case "F":
			System.out.println("Digita nome autore");
			String nome2 = scanner.nextLine();
			System.out.println(" ");
			Stream<Libri> libriStream3 = libri.stream().filter((libro) -> libro.getAutore().getNome().equals(nome2));
			libriStream3.forEach(libro -> {
				System.out.println(
						libro.getCodiceISBN() + " - " + libro.getTitolo() + " - " + libro.getAnnoPubblicazione() + " - "
								+ libro.getNumeroPagine() + " - " + libro.getAutore().getNome() + " "
								+ libro.getAutore().getCognome() + " - " + libro.getGenere());
			});
			break;

		case "G":
			System.out.println("A-Libro B-Rivista");
			String selezione3 = scanner.nextLine();
			System.out.println(" ");
			if (selezione3.equals("A")) {
				System.out.println("Digita codice ISBN: ");
				try {
					long codice = scanner.nextLong();
					System.out.println(" ");
					for (int i = 0; i < libri.size(); i++) {
						if (libri.get(i).getCodiceISBN() == codice) {
							libri.remove(i);
						}
					}
					pulisciFile(fileLibri, "");
					scriviLibriEsistenti(fileLibri, libri);
					for (int i = 0; i < libri.size(); i++) {
						System.out.println(libri.get(i).getCodiceISBN() + " - " + libri.get(i).getTitolo() + " - "
								+ libri.get(i).getAnnoPubblicazione() + " - " + libri.get(i).getNumeroPagine() + " - "
								+ libri.get(i).getAutore().getNome() + " " + libri.get(i).getAutore().getCognome()
								+ " - " + libri.get(i).getGenere());
					}
				} catch (InputMismatchException e) {
					System.out.println("Digita un codice esistente");
				}

			}

			else {
				System.out.println("Digita codice ISBN: ");
				try {
					long codice = scanner.nextLong();
					System.out.println(" ");
					for (int i = 0; i < riviste.size(); i++) {
						if (riviste.get(i).getCodiceISBN() == codice) {
							riviste.remove(i);
						}
					}
					pulisciFile(fileRiviste, "");
					scriviRivisteEsistenti(fileRiviste, riviste);
					for (int i = 0; i < riviste.size(); i++) {
						System.out.println(riviste.get(i).getCodiceISBN() + " - " + riviste.get(i).getTitolo() + " - "
								+ riviste.get(i).getAnnoPubblicazione() + " - " + riviste.get(i).getNumeroPagine()
								+ " - " + riviste.get(i).getPeriodicita());
					}
				} catch (InputMismatchException e) {
					System.out.println("Digita un codice esistente");
				}
			}

			break;
		}
		scanner.close();

	}

	public static void scriviLibriEsistenti(File file, List<Libri> libri) {
		for (int i = 0; i < libri.size(); i++) {
			try {
				scriviLibri(file,
						"\n" + libri.get(i).getCodiceISBN() + " - " + libri.get(i).getTitolo() + " - "
								+ libri.get(i).getAnnoPubblicazione() + " - " + libri.get(i).getNumeroPagine() + " - "
								+ libri.get(i).getAutore().getNome() + " " + libri.get(i).getAutore().getCognome()
								+ " - " + libri.get(i).getGenere(),
						true);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public static void scriviRivisteEsistenti(File file, List<Riviste> riviste) {
		for (int i = 0; i < riviste.size(); i++) {
			try {
				scriviRiviste(file,
						"\n" + riviste.get(i).getCodiceISBN() + " - " + riviste.get(i).getTitolo() + " - "
								+ riviste.get(i).getAnnoPubblicazione() + " - " + riviste.get(i).getNumeroPagine()
								+ " - " + riviste.get(i).getPeriodicita(),
						true);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public static void scriviLibri(File f, String s, boolean append) throws IOException {
		FileUtils.writeStringToFile(f, s, ENCODING, append);
	}

	public static void scriviRiviste(File f, String s, boolean append) throws IOException {
		FileUtils.writeStringToFile(f, s, ENCODING, append);
	}

	public static void leggi(File f) throws IOException {
		System.out.println(FileUtils.readFileToString(f, ENCODING));
	}

	public static void pulisciFile(File f, String s) {
		try {
			FileUtils.writeStringToFile(f, s, ENCODING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
