package it.epicode.exercises.w1d4;

public class Dipendente {

	public static double stipendioBase=1000;
	private String matricola;
	private double stipendio;
	private double importoOrarioStraordinario;
	private Livello livello;
	private Dipartimento dipartimento;
	
	public Dipendente(String matricola, Dipartimento dipartimento) {
		
		this.matricola= matricola;
		this.stipendio= stipendioBase;
		this.importoOrarioStraordinario=30;
		this.livello= Livello.OPERAIO;
		this.dipartimento= dipartimento;
		
	}

	public Dipendente(String matricola,double stipendio, double importoOrarioStraordinario,
			Livello livello, Dipartimento dipartimento) {
		
		this(matricola, dipartimento);
		this.stipendio=stipendio;
		this.importoOrarioStraordinario= importoOrarioStraordinario;
		this.livello= livello;
	}

	public String getMatricola() {
		return matricola;
	}
	
	public double getStipendio() {
		return stipendio;
	}

	public double getImportoOrarioStraordinario() {
		return importoOrarioStraordinario;
	}

	public Livello getLivello() {
		return livello;
	}
	
	public Dipartimento getDipartimento() {
		return dipartimento;
	}

	public void setImportoOrarioStraordinario(double importoOrarioStraordinario) {
		this.importoOrarioStraordinario = importoOrarioStraordinario;
	}

	public void setDipartimento(Dipartimento dipartimento) {
		this.dipartimento = dipartimento;
	}
	
	public void stampaDipendente(){
		System.out.println(stipendioBase);
		System.out.println(this.matricola);
		System.out.println(this.stipendio);
		System.out.println(this.importoOrarioStraordinario);
		System.out.println(this.livello);
		System.out.println(this.dipartimento);
	}
	
	public Livello promuovi(){
		switch(this.livello) {
			case OPERAIO:
				this.livello= Livello.IMPIEGATO;
				this.stipendio=stipendioBase*1.2;
				return this.livello;
			case IMPIEGATO:
				this.livello= Livello.QUADRO;
				this.stipendio=stipendioBase*1.5;
				return this.livello;
			case QUADRO:
				this.livello= Livello.DIRIGENTE;
				this.stipendio=stipendioBase*2;
				return this.livello;
			case DIRIGENTE:
				System.out.println("Errore, non si può promuovere");
				return this.livello;
		}
		return livello;
		
	}
	
	public static double calcolaPaga(Dipendente lavoratore) {
		return lavoratore.stipendio;
	}
	
	public static double calcolaPaga(Dipendente lavoratore, int oreStraordinario) {
		return (lavoratore.stipendio)+(lavoratore.importoOrarioStraordinario*oreStraordinario);
	}

}
