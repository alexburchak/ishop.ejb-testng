package org.ishop.dao.impl;

import org.ishop.dao.ProductDAO;
import org.ishop.domain.Product;

import javax.ejb.Stateless;

/**
 * {@link ProductDAO} implementation
 *
 * @author Alexander Burchak
 */
@Stateless(name = "productDAO")
public class ProductDAOImpl extends AbstractDAO<Product> implements ProductDAO {
    public ProductDAOImpl() {
        super(Product.class);
    }
}
