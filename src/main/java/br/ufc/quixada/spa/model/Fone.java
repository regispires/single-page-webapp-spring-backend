package br.ufc.quixada.spa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Fone {

	public Fone() {}

	public Fone(Integer id) {
		this.id = id;
	}
	
	public Fone(Integer id, String numero, String operadora,
			Participante participante) {
		this.id = id;
		this.numero = numero;
		this.operadora = operadora;
		this.participante = participante;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable=false)
	private String numero;

	private String operadora;

	@ManyToOne
	private Participante participante;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	@Override
	public String toString() {
		return "Fone [id=" + id + ", numero=" + numero + ", operadora="
				+ operadora + "]";
	}

}
