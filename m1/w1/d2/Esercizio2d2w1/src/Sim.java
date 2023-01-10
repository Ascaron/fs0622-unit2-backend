/**
 * 
 */
import java.util.Arrays;

public class Sim {
	
	int numTel;
	double credito;
	int[][] chiamate;
	
	public Sim(int numTel, double credito, int[][] chiamate) {
		
		this.numTel=numTel;
		this.credito=0;
		this.chiamate=new int[0][0];

	}
	
	static void NuovaSim(Sim utente) {
		System.out.println(utente.numTel);
		System.out.println(utente.credito);
		System.out.println(Arrays.toString(utente.chiamate));
	}

	public static void main(String[] args) {

		int[][] chiamateUt1= new int[5][2];
		chiamateUt1[0][0]= 5;
		chiamateUt1[0][1]= 123456;
		chiamateUt1[1][0]= 5;
		chiamateUt1[1][1]= 123456;
		chiamateUt1[2][0]= 5;
		chiamateUt1[2][1]= 123456;
		chiamateUt1[3][0]= 5;
		chiamateUt1[3][1]= 123456;
		chiamateUt1[4][0]= 5;
		chiamateUt1[4][1]= 123456;
		Sim utente1=new Sim(222222, 25, chiamateUt1);
		
		int[][] chiamateUt2= new int[5][2];
		chiamateUt1[0][0]= 5;
		chiamateUt1[0][1]= 123456;
		chiamateUt1[1][0]= 5;
		chiamateUt1[1][1]= 123456;
		chiamateUt1[2][0]= 5;
		chiamateUt1[2][1]= 123456;
		chiamateUt1[3][0]= 5;
		chiamateUt1[3][1]= 123456;
		chiamateUt1[4][0]= 5;
		chiamateUt1[4][1]= 123456;
		Sim utente2=new Sim(333333, 15, chiamateUt2);
		NuovaSim(utente1);
		NuovaSim(utente2);
		
	}

}
