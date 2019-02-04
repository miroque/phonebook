package ru.miroque.phonebook.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T extends Serializable, ID> {
	void persist(final T entity);

	T merge(final T entity);

	T getById(final ID id);

	List<T> getAll();

	void delete(final ID entity);

	void delete(T entity);

	void detach(T entity);
}
