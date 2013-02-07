package org.ishop.dao.impl;

import org.ishop.dao.DAO;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

/**
 * Abstract DAO
 *
 * @author Alexander Burchak
 */
public abstract class AbstractDAO<T> implements DAO<T> {
    @PersistenceContext(unitName = "ishopPU")
    private EntityManager entityManager;

    private Class<T> clazz;

    protected AbstractDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void save(T obj) {
        entityManager.persist(obj);
    }

    public T get(Long id) {
        return entityManager.find(clazz, id);
    }
}
