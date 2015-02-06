package br.ufc.quixada.spa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Instituicao {

	public Instituicao() {}

	public Instituicao(Integer id) {
		this.id = id;
	}
	
	public Instituicao(Integer id, String sigla, String nome) {
		this.id = id;
		this.sigla = sigla;
		this.nome = nome;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable=false, unique=true)
	private String sigla;

	@Column(nullable=false)
	
	@Size(min = 5, message = "O nome deve ter no mínimo 5 caracteres")
	private String nome;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Instituicao [id=" + id + ", sigla=" + sigla + ", nome=" + nome
				+ "]";
	}

}
