package br.ufc.quixada.spa.controller;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.ufc.quixada.npi.enumeration.ResponseStatus;
import br.ufc.quixada.npi.model.ResponseStatusMessage;
import br.ufc.quixada.spa.service.PovoaService;

@Named
@RequestMapping("/povoa")
public class PovoaController {

	@Inject
	private PovoaService povoaService;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ResponseStatusMessage execute() {
		log.debug("Povoa - GET");
		povoaService.execute();
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Povoamento realizado com sucesso");
	}

}
