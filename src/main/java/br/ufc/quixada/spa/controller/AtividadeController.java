package br.ufc.quixada.spa.controller;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.ufc.quixada.npi.enumeration.ResponseStatus;
import br.ufc.quixada.npi.model.ResponseStatusMessage;
import br.ufc.quixada.spa.model.Atividade;
import br.ufc.quixada.spa.model.Participante;
import br.ufc.quixada.spa.service.AtividadeService;

@Named
@RequestMapping("/atividades")
public class AtividadeController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Inject
	private AtividadeService atividadeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Atividade> findAll() {
		log.debug("Atividade - GET (all)");
		return atividadeService.find(Atividade.class);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public @ResponseBody Atividade findById(@PathVariable Integer id) {
		log.debug("Atividade - GET (id)");
		return atividadeService.find(Atividade.class, id);
	}
	
	@RequestMapping(value="{id}/participantes", method = RequestMethod.GET)
	public @ResponseBody List<Participante> findParticipantesById(@PathVariable Integer id) {
		log.debug("Atividade - GET (id) - findParticipantesById");
		return atividadeService.findParticipantesById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody ResponseStatusMessage insert(@Valid Atividade atividade) {
		log.debug("Atividade - POST");
		atividadeService.save(atividade);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Atividade inserida com sucesso");
	}

	@RequestMapping(value="{idAtividade}/participantes/{idParticipante}", method = RequestMethod.POST)
	public @ResponseBody ResponseStatusMessage insereParticipanteEmAtividade(@PathVariable Integer idAtividade, @PathVariable Integer idParticipante) {
		log.debug("Atividade - POST - insere participante em atividade");
		String msg = atividadeService.insereParticipanteEmAtividade(idParticipante, idAtividade);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, msg);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseStatusMessage delete(@PathVariable Integer id) {
		log.debug("Atividade - DELETE");
		atividadeService.delete(new Atividade(id));
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Atividade removida com sucesso");
	}
	
	@RequestMapping(value="{idAtividade}/participantes/{idParticipante}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseStatusMessage removeParticipanteDeAtividade(@PathVariable Integer idAtividade, @PathVariable Integer idParticipante) {
		log.debug("Atividade - DELETE");
		String msg = atividadeService.removeParticipanteDeAtividade(idParticipante, idAtividade);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, msg);
	}

	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public @ResponseBody ResponseStatusMessage update(Atividade atividade, @PathVariable Integer id) {
		log.debug("Atividade - PUT");
		atividade.setId(id);
		log.debug("Updating Atividade: {}", atividade);
		atividadeService.update(atividade);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Atividade atualizada com sucesso");
	}
	
	
	
}
