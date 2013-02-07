package org.ishop.dao;

/**
 * Base DAO
 *
 * @author Alexander Burchak
 */
public interface DAO<T> {
    void save(T obj);

    T get(Long id);
}
