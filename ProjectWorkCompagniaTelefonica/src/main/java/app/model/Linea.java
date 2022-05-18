package app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="linee")
public class Linea {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_linea")
	private Integer idLinea;
	
	@NotBlank(message="numero obbligatorio")
	@Size(max=20, message="massimo 20 caratteri")
	@Column(name="numero")
	private String numero;
	
	@NotBlank(message="tipo obbligatorio")
	@Size(max=10, message="massimo 10 caratteri")
	@Column(name="tipo")
	private String tipo;
	
	@NotBlank(message="stato obbligatorio")
	@Size(max=10, message="massimo 10 caratteri")
	@Column(name="stato")
	private String stato;
	
	@ManyToOne
	@JoinColumn(name="id_cliente")
	@NotNull(message="cliente obbligatorio")
	private Cliente cliente;

	public Linea() {
		super();
	}

	public Integer getIdLinea() {
		return idLinea;
	}

	public void setIdLinea(Integer idLinea) {
		this.idLinea = idLinea;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
