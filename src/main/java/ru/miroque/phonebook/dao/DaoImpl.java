package ru.miroque.phonebook.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

@Transactional
public abstract class DaoImpl<T extends Serializable, ID> implements Dao<T, ID>{
	private final Class<T> clazz;
	private int batchSize = 30;

	@Inject
	private EntityManager em;

	public DaoImpl(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public void persist(final T entity) {
		em.persist(entity);
		em.flush();
	}

	@Override
	public void delete(ID id) {
		T entity = em.getReference(clazz, id);
		em.remove(entity);
		em.flush();
	}

	@Override
	public void delete(T entity) {
		em.remove(em.merge(entity));
		em.flush();
	}

	@Override
	public void detach(T entity) {
		em.detach(entity);
	}

	@Override
	public List<T> getAll() {
		final CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(clazz);
		criteriaQuery.select(criteriaQuery.from(clazz));
		return em.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public T getById(ID id) {
		return em.find(clazz, id);
	}

	@Override
	public T merge(T entity) {
		T t = em.merge(entity);
		em.flush();
		return t;
	}

	public Collection<T> bulkSave(Collection<T> entities) {
		final List<T> savedEntities = new ArrayList<>(entities.size());
		int i = 0;
		for (T t : entities) {
			savedEntities.add(em.merge(t));
			i++;
			if (i % batchSize == 0) {
				// Flush a batch of inserts and release memory.
				em.flush();
				em.clear();
			}
		}
		return savedEntities;
	}

	protected EntityManager em() {
		return em;
	}

	protected Class<T> getClazz() {
		return clazz;
	}
}
