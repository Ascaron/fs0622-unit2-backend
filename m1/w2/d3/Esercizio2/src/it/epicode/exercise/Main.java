package it.epicode.exercise;

import java.util.ArrayList;
import java.util.List;

public class Main extends Thread {

	static List<Integer> numeri = new ArrayList<>();
	int inizio = 0;
	int tot = 0;

	public Main(int inizio) {

		this.inizio = inizio;
	}

	public static void main(String[] args) throws InterruptedException {

		Main m1 = new Main(0);
		Main m2 = new Main(1000);
		Main m3 = new Main(2000);
		generaNumeri();

		try {
			m1.start();
			m2.start();
			m3.start();
			m1.join();
			m2.join();
			m3.join();
			System.out.println("Somma totale: " + Integer.toString(m1.tot + m2.tot + m3.tot));
		} catch (IndexOutOfBoundsException e) {}

	}

	public static void generaNumeri() {
		for (int i = 0; i < 3000; i++) {
			numeri.add((int) Math.floor(Math.random() * 10 + 1));
		}
	}

	@Override
	public void run() {
		this.tot = 0;
		for (int i = this.inizio; i < this.inizio + 1000; i++) {
			this.tot += numeri.get(i);
		}
		System.out.println("Somma parziale: " + Integer.toString(this.tot));
	}

}

/*
 * Scrivere un programma multithread in Java che dato un array di 3000 valori
 * numerici generati casualmente ne esegue la somma in modo parallelo. Creare 3
 * thread e assegnare ad ogni thread una partizione dell’array (1000 valori).
 * Ogni thread esegue la somma dei propri valori e mettere il risultato in una
 * struttura dati del thread main contenente i risultati parziali. Il thread
 * main deve sincronizzarsi sulla terminazione (join) dei thread figli dopodiché
 * somma i risultati parziali e li stampa su console.
 */