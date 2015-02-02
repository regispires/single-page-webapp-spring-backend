package br.ufc.quixada.spa;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.ufc.quixada.npi.service.GenericService;
import br.ufc.quixada.spa.model.Atividade;

@Named
@RequestMapping("/atividade")
public class AtividadeController {

	@Inject
	private GenericService<Atividade> atividadeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Atividade> findAll() {
		
		return atividadeService.find(Atividade.class);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public @ResponseBody Atividade findById(@PathVariable Integer id) {
		
		return atividadeService.find(Atividade.class, id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Atividade save(@RequestBody Atividade atividade) {
		
		atividadeService.save(atividade);
		return atividade;
	}
	
}
