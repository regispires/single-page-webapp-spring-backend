package br.ufc.quixada.spa;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value="/test/{name}", method = RequestMethod.GET)
	public @ResponseBody Atividade test(@PathVariable String name) {
		
		Atividade a = new Atividade();
		a.setId(1l);
		a.setNome(name);
		a.setQtdVagas(20);
		return a;
 
	}

}
