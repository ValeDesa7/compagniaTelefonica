package app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="clienti")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private Integer idCliente;
	
	@NotBlank(message="nome obbligatorio")
	@Size(max=20, message="massimo 20 caratteri")
	@Column(name="nome")
	private String nome;
	
	@NotBlank(message="codice fiscale obbligatorio")
	@Size(max=20, message="massimo 20 caratteri")
	@Column(name="codice_fiscale")
	private String codiceFiscale;
	
	@NotBlank(message="email obbligatoria")
	@Pattern(regexp = "(.+?)@(.+?)", message="email non valida")
	@Size(max=30, message="massimo 30 caratteri")
	@Column(name="email")
	private String email;

	public Cliente() {
		super();
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
