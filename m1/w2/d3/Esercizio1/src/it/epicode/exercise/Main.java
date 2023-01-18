package it.epicode.exercise;

public class Main extends Thread{
	
	String str;
	
	public Main(String str) {
		
		this.str=str;
	}

	public static void main(String[] args) {

		Main str1=new Main("*");
		Main str2=new Main("#");
		
		str1.start();
		str2.start();
	}

	public void stampa() {
		for (int i=0; i<10; i++) {
			System.out.println((i+1)+ this.str);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
	
	@Override
	public void run() {
		this.stampa();
	}
}

/*Creare un’applicazione con due thread figli. Ciascuno dei due thread ha associato un simbolo (ad es. * o #).
 *  Fare in modo che ciascun thread stampi su console il proprio simbolo per 10 volte, attendendo 1 secondo tra una stampa e 
 *  l'altra.*/