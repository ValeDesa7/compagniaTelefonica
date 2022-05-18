package app.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="chiamate")
public class Chiamata {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_chiamata")
	private Long idChiamata;
	
	@NotNull(message="data inizio obbligatoria")
	@Column(name="data_inizio")
	private Timestamp dataInizio;
	
	@NotNull(message="data fine obbligatoria")
	@Column(name="data_fine")
	private Timestamp dataFine;
	
	@Column(name="durata")
	private Long durata;
	
	@ManyToOne
	@JoinColumn(name="id_linea")
	@NotNull(message="linea obbligatoria")
	private Linea linea;

	public Chiamata() {
		super();
	}

	public Long getIdChiamata() {
		return idChiamata;
	}

	public void setIdChiamata(Long idChiamata) {
		this.idChiamata = idChiamata;
	}
	
	public Timestamp getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Timestamp dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Timestamp getDataFine() {
		return dataFine;
	}

	public void setDataFine(Timestamp dataFine) {
		this.dataFine = dataFine;
	}
	
	public Long getDurata() {
		return durata;
	}

	public void setDurata() {
		Long differenza = dataFine.getTime()-dataInizio.getTime();
        durata = differenza/1000; 
	}

	public Linea getLinea() {
		return linea;
	}

	public void setLinea(Linea linea) {
		this.linea = linea;
	}
	
}
