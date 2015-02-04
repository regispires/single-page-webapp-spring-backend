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
import br.ufc.quixada.spa.model.Instituicao;

@Named
@RequestMapping("/instituicoes")
public class InstituicaoController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Inject
	private GenericService<Instituicao> instituicaoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Instituicao> findAll() {
		log.debug("Instituicao - GET (all)");
		return instituicaoService.find(Instituicao.class);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public @ResponseBody Instituicao findById(@PathVariable Integer id) {
		log.debug("Instituicao - GET (id)");
		return instituicaoService.find(Instituicao.class, id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody ResponseStatusMessage save(Instituicao atividade) {
		log.debug("Instituicao - POST");
		instituicaoService.save(atividade);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Instituicao inserida com sucesso");
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseStatusMessage delete(@PathVariable Integer id) {
		log.debug("Instituicao - DELETE");
		instituicaoService.delete(new Instituicao(id));
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Instituicao removida com sucesso");
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public @ResponseBody ResponseStatusMessage update(Instituicao instituicao, @PathVariable Integer id) {
		log.debug("Instituicao - PUT");
		instituicao.setId(id);
		log.debug("Updating Instituicao: {}", instituicao);
		instituicaoService.update(instituicao);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Instituicao atualizada com sucesso");
	}
	
}
