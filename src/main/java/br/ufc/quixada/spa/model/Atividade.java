package br.ufc.quixada.spa.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Atividade {

	public Atividade() {}
	
	public Atividade(Integer id) {
		this.id = id;
	}
	
	public Atividade(Integer id, String nome, Integer qtdVagas,
			List<Participante> participantes) {
		super();
		this.id = id;
		this.nome = nome;
		this.qtdVagas = qtdVagas;
		this.participantes = participantes;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false, unique=true)
	@Size(min = 5, message = "O nome deve ter no mínimo 5 caracteres")
	private String nome;
	
	private Integer qtdVagas;

	@ManyToMany(mappedBy="atividades")
	//@JsonManagedReference
	@JsonIgnore
	private List<Participante> participantes;
	
	
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

	public List<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}

	public int getQtdVagas() {
		return qtdVagas;
	}

	public void setQtdVagas(Integer qtdVagas) {
		this.qtdVagas = qtdVagas;
	}

	@Override
	public String toString() {
		return "Atividade [id=" + id + ", nome=" + nome + ", qtdVagas="
				+ qtdVagas + "]";
	}
	
}
