package br.ufc.quixada.spa.service;

import java.util.List;

import br.ufc.quixada.npi.service.GenericService;
import br.ufc.quixada.spa.model.Atividade;
import br.ufc.quixada.spa.model.Participante;

public interface AtividadeService extends GenericService<Atividade> {

	public String insereParticipanteEmAtividade(Integer idParticipante, Integer idAtividade);

	public String removeParticipanteDeAtividade(Integer idParticipante, Integer idAtividade);

	public List<Participante> findParticipantesById(Integer id);
	
}
