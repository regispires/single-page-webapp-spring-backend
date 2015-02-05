package br.ufc.quixada.spa.service.impl;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.ufc.quixada.npi.enumeration.QueryType;
import br.ufc.quixada.npi.service.GenericService;
import br.ufc.quixada.npi.service.impl.GenericServiceImpl;
import br.ufc.quixada.npi.util.SimpleMap;
import br.ufc.quixada.spa.model.Atividade;
import br.ufc.quixada.spa.model.Participante;
import br.ufc.quixada.spa.service.ParticipanteService;

@Named
public class ParticipanteServiceImpl extends GenericServiceImpl<Participante> implements ParticipanteService {

	@Inject
	private GenericService<Atividade> atividadeService;
	
	@Transactional
	public String insereAtividadeEmParticipante(Integer idAtividade, Integer idParticipante) {
		Atividade atividade = atividadeService.find(Atividade.class, idAtividade);
		Participante participante = find(Participante.class, idParticipante);

		// Insere atividade em participante apenas se o participante ainda não estiver naquela atividade
		if (! findAtividadeEmParticipante(idAtividade, idParticipante)) {
			participante.getAtividades().add(atividade);
			update(participante);
			return "Participante inserido com sucesso na atividade";
		} else {
			return "Participante já estava cadastrado na atividade";
		}
	}
	
	private boolean findAtividadeEmParticipante(Integer idAtividade, Integer idParticipante) {
		Object obj = findFirst(QueryType.NATIVE, 
				"select * from participante_atividade where participante_id = :idParticipante and atividade_id = :idAtividade",
				new SimpleMap<String, Object>("idAtividade", idAtividade, "idParticipante", idParticipante));
		return obj != null;
	}
	
}
