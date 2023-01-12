package it.epicode.exercises.w1d4;

public class GestioneDipendenti {

	public static void main(String[] args) {
		
		Dipendente lavoratore1= new Dipendente("111", 1000, 30, Livello.OPERAIO, Dipartimento.PRODUZIONE);
		Dipendente lavoratore2= new Dipendente("222", 1000, 30, Livello.OPERAIO, Dipartimento.PRODUZIONE);
		Dipendente lavoratore3= new Dipendente("333", 1000, 30, Livello.IMPIEGATO, Dipartimento.AMMINISTRAZIONE);
		Dipendente lavoratore4= new Dipendente("444", 1000, 30, Livello.DIRIGENTE, Dipartimento.VENDITE);
		
		lavoratore1.promuovi();
		lavoratore1.stampaDipendente();
		System.out.println("--------");
		lavoratore2.stampaDipendente();
		System.out.println("--------");
		lavoratore3.promuovi();
		lavoratore3.stampaDipendente();
		System.out.println("--------");
		lavoratore4.stampaDipendente();
		System.out.println("--------");
		System.out.println(Dipendente.calcolaPaga(lavoratore1));
		System.out.println("--------");
		System.out.println(Dipendente.calcolaPaga(lavoratore1, 5)+Dipendente.calcolaPaga(lavoratore2, 5)+
				Dipendente.calcolaPaga(lavoratore3, 5)+Dipendente.calcolaPaga(lavoratore4, 5));

	}

}
