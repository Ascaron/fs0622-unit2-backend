/**
 * 
 */
package d2w1;

public class Rettangolo {
	
	double height;
	double width;
	
	public  Rettangolo(double height, double width) {
		
		this.height= height;
		this.width=width;
	}
	
	static double Area(Rettangolo r) {
		return r.height*r.width;
	}
	
	static double Perimetro(Rettangolo r) {
		return (r.height*2)+(r.width*2);
	}

	public static void main(String[] args) {
		
		Rettangolo r1= new Rettangolo(10, 20);
		
		System.out.println(Area(r1));
		System.out.println(Perimetro(r1));
		
		Rettangolo r2=new Rettangolo (20, 40);
		
		System.out.println(Area(r2));
		System.out.println(Perimetro(r2));
		
		System.out.println(Area(r1)+Area(r2));
		System.out.println(Perimetro(r1)+Perimetro(r2));
	}

}
