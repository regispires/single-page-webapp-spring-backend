package br.ufc.quixada.npi.service.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import br.ufc.quixada.npi.enumeration.QueryType;
import br.ufc.quixada.npi.repository.GenericRepository;
import br.ufc.quixada.npi.service.GenericService;

@Named
public class GenericServiceImpl<T> implements GenericService<T> {

	@Inject
	private GenericRepository<T> repository;
	
	@Transactional
	public void save(T entity) {
		repository.save(entity);
	}

	@Transactional
	public void update(T entity) {
		repository.update(entity);
	}

	@Transactional
	public void delete(T entity) {
		repository.delete(entity);
	}

	public List<T> find(Class<T> entityClass) {
		return find(entityClass, -1, -1);
	}

	public List<T> find(QueryType type, String query, Map<String, Object> namedParams) {
		return find(type, query, namedParams, -1, -1);
	}
	
	public List<T> find(String query, Map<String, Object> namedParams) {
		return find(query, namedParams, -1, -1);
	}
	
	public T findFirst(String query, Map<String, Object> namedParams) {
		return findFirst(query, namedParams, -1);
	}

	public List<T> find(String queryName, Map<String, Object> namedParams,
			int firstResult, int maxResults) {
		return find(QueryType.NAMED, queryName, namedParams, firstResult, maxResults);
	}
	
	public T findFirst(String query, Map<String, Object> namedParams,
			int firstResult) {
		return findFirst(QueryType.NAMED, query, namedParams, firstResult);
	}
	
	public T find(Class<T> entityClass, Object id) {
		return repository.find(entityClass, id);
	}
	
	public List<T> find(Class<T> entityClass, int firstResult, int maxResults) {
		return repository.find(entityClass, firstResult, maxResults);
	}

	public List<T> find(QueryType type, String query,
			Map<String, Object> namedParams, int firstResult, int maxResults) {
		return repository.find(type, query, namedParams, firstResult, maxResults);
	}
	
	public T findFirst(QueryType type, String query,
			Map<String, Object> namedParams, int firstResult) {
		return repository.findFirst(type, query, namedParams, firstResult);
	}
}
