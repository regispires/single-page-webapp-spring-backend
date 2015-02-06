package br.ufc.quixada.spa.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Participante {

	public Participante() {}

	public Participante(Integer id) {
		this.id = id;
	}

	public Participante(Integer id, String nome, String email,
			Double valorPago, Date dataPagamento, List<Fone> fones,
			List<Atividade> atividades, Instituicao instituicao) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.valorPago = valorPago;
		this.dataPagamento = dataPagamento;
		this.fones = fones;
		this.atividades = atividades;
		this.instituicao = instituicao;
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
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date dataPagamento;

	@OneToMany(mappedBy="participante", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Fone> fones;
	
	@ManyToMany
	@JoinTable(name="participante_atividade", joinColumns={@JoinColumn(name="participante_id")}, inverseJoinColumns={@JoinColumn(name="atividade_id")})
	@JsonIgnore
	// Especificar join column e inverse join column para evitar que fique: atividades_id e participantes_id 
	private List<Atividade> atividades;
	
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

	public List<Fone> getFones() {
		return fones;
	}

	public void setFones(List<Fone> fones) {
		this.fones = fones;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	@Override
	public String toString() {
		return "Participante [id=" + id + ", nome=" + nome + ", email=" + email
				+ ", valorPago=" + valorPago + ", dataPagamento="
				+ dataPagamento + "]";
	}

}
