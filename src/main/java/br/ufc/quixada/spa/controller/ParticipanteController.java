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
import br.ufc.quixada.spa.model.Participante;

@Named
@RequestMapping("/participantes")
public class ParticipanteController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Inject
	private GenericService<Participante> participanteService;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Participante> findAll() {
		log.debug("Participante - GET (all)");
		return participanteService.find(Participante.class);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public @ResponseBody Participante findById(@PathVariable Integer id) {
		log.debug("Participante - GET (id)");
		return participanteService.find(Participante.class, id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody ResponseStatusMessage insert(Participante participante) {
		log.debug("Participante - POST");
		participanteService.save(participante);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Participante inserido com sucesso");
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseStatusMessage delete(@PathVariable Integer id) {
		log.debug("Participante - DELETE");
		participanteService.delete(new Participante(id));
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Participante removido com sucesso");
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public @ResponseBody ResponseStatusMessage update(Participante participante, @PathVariable Integer id) {
		log.debug("Participante - PUT");
		participante.setId(id);
		log.debug("Updating Participante: {}", participante);
		participanteService.update(participante);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Participante atualizado com sucesso");
	}
	
}
