
public class Carrello {

	int clienteAssociato;
	String[] elencoArticoli;
	double totale;
	
	public Carrello(int clienteAssociato, String[] elencoArticoli, double totale) {
		
		this.clienteAssociato=clienteAssociato;
		this.elencoArticoli=elencoArticoli;
		this.totale=totale;
	}
}
