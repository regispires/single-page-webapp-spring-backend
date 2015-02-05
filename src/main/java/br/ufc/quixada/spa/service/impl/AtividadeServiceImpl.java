package br.ufc.quixada.spa.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.ufc.quixada.npi.service.impl.GenericServiceImpl;
import br.ufc.quixada.npi.util.SimpleMap;
import br.ufc.quixada.spa.model.Atividade;
import br.ufc.quixada.spa.model.Participante;
import br.ufc.quixada.spa.service.AtividadeService;
import br.ufc.quixada.spa.service.ParticipanteService;

@Named
public class AtividadeServiceImpl extends GenericServiceImpl<Atividade> implements AtividadeService {

	@Inject
	private ParticipanteService participanteService;
	
	@Transactional
	@Override
	public String insereParticipanteEmAtividade(Integer idParticipante, Integer idAtividade) {
		return participanteService.insereAtividadeEmParticipante(idAtividade, idParticipante);
	}
	
	@Transactional
	@Override
	public String removeParticipanteDeAtividade(Integer idParticipante, Integer idAtividade) {
		int n = executeUpdate("delete from participante_atividade where participante_id = :idParticipante and atividade_id = :idAtividade", 
				new SimpleMap<String, Object>("idParticipante", idParticipante, "idAtividade", idAtividade));
		if (n == 0) {
			return "Participante não estava cadastrado na atividade";
		} else {
			return "Participante removido com sucesso da atividade";
		}
	}
	
	@Override
	public List<Participante> findParticipantesById(Integer id) {
		Atividade atividade = find(Atividade.class, id);
		return atividade.getParticipantes();
	}
	
}
