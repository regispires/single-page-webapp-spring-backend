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
	@Override
	public void save(T entity) {
		repository.save(entity);
	}

	@Transactional
	@Override
	public void update(T entity) {
		repository.update(entity);
	}

	@Transactional
	@Override
	public void delete(T entity) {
		repository.delete(entity);
	}

	@Override
	public List<T> find(Class<T> entityClass) {
		return find(entityClass, -1, -1);
	}

	@Override
	public T find(Class<T> entityClass, Object id) {
		return repository.find(entityClass, id);
	}
	
	@Override
	public List<T> find(Class<T> entityClass, int firstResult, int maxResults) {
		return repository.find(entityClass, firstResult, maxResults);
	}

	
	@SuppressWarnings("rawtypes")
	@Override
	public List find(QueryType type, String query, Map<String, Object> namedParams) {
		return find(type, query, namedParams, -1, -1);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List find(String query, Map<String, Object> namedParams) {
		return find(query, namedParams, -1, -1);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List find(String queryName, Map<String, Object> namedParams,
			int firstResult, int maxResults) {
		return find(QueryType.NAMED, queryName, namedParams, firstResult, maxResults);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List find(QueryType type, String query,
			Map<String, Object> namedParams, int firstResult, int maxResults) {
		return repository.find(type, query, namedParams, firstResult, maxResults);
	}
	
	@Override
	public Object findFirst(String query, Map<String, Object> namedParams) {
		return findFirst(QueryType.NAMED, query, namedParams);
	}
	
	@Override
	public Object findFirst(QueryType type, String query, Map<String, Object> namedParams) {
		return repository.findFirst(type, query, namedParams);
	}

	@Override
	public int executeUpdate(String sql, Map<String, Object> namedParams) {
		return repository.executeUpdate(sql, namedParams);
	}
}
