package br.ufc.quixada.spa.controller;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.ufc.quixada.npi.enumeration.ResponseStatus;
import br.ufc.quixada.npi.model.ResponseStatusMessage;
import br.ufc.quixada.npi.service.GenericService;
import br.ufc.quixada.spa.model.Atividade;

@Named
@RequestMapping("/atividades")
public class AtividadeController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Inject
	private GenericService<Atividade> atividadeService;
	
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
	
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody ResponseStatusMessage save(Atividade atividade) {
		log.debug("Atividade - POST");
		atividadeService.save(atividade);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Atividade inserida com sucesso");
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseStatusMessage delete(@PathVariable Integer id) {
		log.debug("Atividade - DELETE");
		atividadeService.delete(new Atividade(id));
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Atividade removida com sucesso");
	}

	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public @ResponseBody ResponseStatusMessage update(Atividade atividade) {
		log.debug("Atividade - PUT");
		atividadeService.update(atividade);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Atividade atualizada com sucesso");
	}
	
}
