package br.ufc.quixada.spa.service;

import br.ufc.quixada.npi.service.GenericService;
import br.ufc.quixada.spa.model.Participante;

public interface ParticipanteService extends GenericService<Participante> {

	public String insereAtividadeEmParticipante(Integer idAtividade, Integer idParticipante);
	
	
	
}
