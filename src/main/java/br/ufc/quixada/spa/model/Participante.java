package br.ufc.quixada.spa.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Participante {

	public Participante() {}

	public Participante(Integer id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Size(min = 2, message = "O nome deve ter no mínimo 2 caracteres")
	@Column(nullable=false)
	private String nome;

	@Column(nullable=false, unique=true)
	private String email;

	private Double valorPago;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date dataPagamento;

	@OneToMany(mappedBy="participante")
	private List<Fone> fone;
	
	@ManyToMany
	private List<Atividade> atividade;
	
	@ManyToOne
	private Instituicao instituicao;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getValorPago() {
		return valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	@Override
	public String toString() {
		return "Participante [id=" + id + ", nome=" + nome + ", email=" + email
				+ ", valorPago=" + valorPago + ", dataPagamento="
				+ dataPagamento + "]";
	}

}
