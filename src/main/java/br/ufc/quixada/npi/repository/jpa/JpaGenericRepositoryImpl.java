package br.ufc.quixada.npi.repository.jpa;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import br.ufc.quixada.npi.enumeration.QueryType;
import br.ufc.quixada.npi.repository.GenericRepository;


@Named
public class JpaGenericRepositoryImpl<T> implements GenericRepository<T> {

	private static Logger log = LoggerFactory.getLogger(JpaGenericRepositoryImpl.class);

	protected EntityManager em;

	@Override
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		log.debug("Setting EntityManager: {} {} ", this.getClass(), em);
		this.em = em;
	}

	@Override
	@Transactional
	public void save(T entity) {
		this.em.persist(entity);
	}

	@Override
	@Transactional
	public void update(T entity) {
		this.em.merge(entity);
	}

	@Override
	@Transactional
	public void delete(T entity) {
		em.remove(em.merge(entity));
	}

	@Override
	@Transactional(readOnly=true)
	public T find(Class<T> entityClass, Object id) {
		T result = null;
		result = em.find(entityClass, id);
		return result;
	}

	@Override
	public List<T> find(Class<T> entityClass) {
		return find(entityClass, -1, -1);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<T> find(Class<T> entityClass, int firstResult, int maxResults) {
		List<T> result = null;
		Query q = em.createQuery("select obj from "
				+ entityClass.getSimpleName() + " obj");
		if (firstResult >= 0 && maxResults >= 0) {
			q = q.setFirstResult(firstResult).setMaxResults(maxResults);
		}
		result = q.getResultList();
		return result;
	}

	@SuppressWarnings({ "rawtypes" })
	@Override
	public List find(String queryName, Map<String, Object> namedParams) {
		return find(QueryType.NAMED, queryName, namedParams);
	}

	@SuppressWarnings({ "rawtypes" })
	@Override
	public List find(QueryType type, String query,
			Map<String, Object> namedParams) {
		return find(type, query, namedParams, -1, -1);
	}

	@SuppressWarnings({ "rawtypes" })
	@Override
	public List find(String queryName, Map<String, Object> namedParams,
			int firstResult, int maxResults) {
		return find(QueryType.NAMED, queryName, namedParams, firstResult,
				maxResults);
	}

	@SuppressWarnings({ "rawtypes" })
	@Override
	@Transactional(readOnly=true)
	public List find(QueryType type, String query,
			Map<String, Object> namedParams, int firstResult, int maxResults) {
		List result = null;
		Query q;
		if (type == QueryType.JPQL) {
			q = em.createQuery(query);
		} else if (type == QueryType.NATIVE) {
			q = em.createNativeQuery(query);
		} else if (type == QueryType.NAMED) {
			q = em.createNamedQuery(query);
		} else {
			throw new IllegalArgumentException("Invalid query type: " + type);
		}

		setNamedParameters(q, namedParams);

		if (firstResult >= 0 && maxResults >= 0) {
			q = q.setFirstResult(firstResult).setMaxResults(maxResults);
		}

		result = q.getResultList();

		return result;
	}

	private void setNamedParameters(Query q, Map<String, Object> namedParams) {
		if (namedParams != null) {
			log.debug("Named parameters: {}", namedParams);
			Set<String> keys = namedParams.keySet();
			for (String key : keys) {
				q.setParameter(key, namedParams.get(key));
			}
		}
	}
	
	@Override
	public Object findFirst(String query, Map<String, Object> namedParams) {
		return findFirst(QueryType.NAMED, query, namedParams);
	}

	@Override
	public Object findFirst(QueryType type, String query, Map<String, Object> namedParams) {

		@SuppressWarnings("rawtypes")
		List result = find(type, query, namedParams, 0, 1);
		return result == null || result.size() == 0 ? null : result.get(0);
	}

	public int executeUpdate(String sql, Map<String, Object> namedParams) {
		Query q = em.createNativeQuery(sql);
		setNamedParameters(q, namedParams);
		return q.executeUpdate();
	}
	
}
