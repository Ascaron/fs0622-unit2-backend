
public class Cliente {

	int codiceCli;
	String[] nomeCognome;
	String email;
	int[] dataIscrizione;
	
	public Cliente(int codiceCli, String[] nomeCognome, String email, int[] dataIscrizione) {
		
		this.codiceCli= codiceCli;
		this.nomeCognome= nomeCognome;
		this.email= email;
		this.dataIscrizione= dataIscrizione;
	}
}
