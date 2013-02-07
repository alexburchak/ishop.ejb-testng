package org.ishop.dao;

import org.ishop.domain.Product;

import javax.ejb.Local;

/**
 * Product DAO
 *
 * @author Alexander Burchak
 */
@Local
public interface ProductDAO extends DAO<Product> {
}
