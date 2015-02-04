package br.ufc.quixada.spa.service.impl;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.ufc.quixada.npi.repository.GenericRepository;
import br.ufc.quixada.npi.repository.jpa.JpaGenericRepositoryImpl;
import br.ufc.quixada.spa.model.Atividade;
import br.ufc.quixada.spa.model.Instituicao;
import br.ufc.quixada.spa.model.Participante;
import br.ufc.quixada.spa.service.PovoaService;

@Named
public class PovoaServiceImpl implements PovoaService {

	@Inject
	private GenericRepository<Instituicao> instituicaoRepo = new JpaGenericRepositoryImpl<Instituicao>();
	
	@Inject
	private GenericRepository<Atividade> atividadeRepo = new JpaGenericRepositoryImpl<Atividade>();
	
	@Inject
	private GenericRepository<Participante> participanteRepo = new JpaGenericRepositoryImpl<Participante>();

	@Transactional
	@Override
	public void execute() {
		Instituicao i1 = new Instituicao(null, "UFC", "Universidade Federal do Ceará");
		instituicaoRepo.save(i1);
		System.out.println(i1);
		instituicaoRepo.save(new Instituicao(null, "UFPI", "Universidade Federal do Piauí"));
		instituicaoRepo.save(new Instituicao(null, "IFPI", "Instituto Federal do Piauí"));
		instituicaoRepo.save(new Instituicao(null, "IFCE", "Instituto Federal do Ceará"));

		//atividadeRepo.save(entity);
		
//		insert into atividade (nome, qtdvagas) values ('Minicurso SPA', 20);
//		insert into atividade (nome, qtdvagas) values ('Minicurso jQuery', 21);
//		insert into atividade (nome, qtdvagas) values ('Minicurso SQL', 22);

		
		
	}
	
}
