package it.epicode.gestioneeventi;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import it.epicode.gestioneeventi.model.TipoEvento;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name="evento")
@Getter
@Setter
@ToString
@Entity
public class Evento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String titolo;
	private LocalDate dataEvento;
	private String descrizione;
	@Enumerated(EnumType.STRING)
	private TipoEvento tipoEvento;
	private int numeroMassimoPartecipanti;
	
	public int getId() {
		return id;
	}
	public String getTitolo() {
		return titolo;
	}
	public LocalDate getDataEvento() {
		return dataEvento;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}
	public int getNumeroMassimoPartecipanti() {
		return numeroMassimoPartecipanti;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public void setDataEvento(LocalDate dataEvento) {
		this.dataEvento = dataEvento;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
	}
}
