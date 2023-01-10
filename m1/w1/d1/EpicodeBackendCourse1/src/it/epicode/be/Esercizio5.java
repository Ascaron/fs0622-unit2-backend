/**
 * 
 */
package it.epicode.be;


public class Esercizio5 {


	public static void main(String[] args) {
		System.out.println(PerimetroRettangolo(10.5, 15.5));
		System.out.println(PariDispari(10));
		System.out.println(AreaTriangolo(3, 4, 5));
	}
	
	static double PerimetroRettangolo(double base, double altezza) {
		return (base*2)+(altezza*2);
	}
	
	static int PariDispari(int valore) {
		return valore%2;
	}
	
	static double AreaTriangolo(double lato1, double lato2, double lato3) {
		double perimetro=lato1+lato2+lato3;
		double semiperimetro=perimetro/2;
		double areaTriangolo= Math.sqrt((semiperimetro)*(semiperimetro-lato1)*(semiperimetro-lato2)*(semiperimetro-lato3));
		return areaTriangolo;
	}
}
