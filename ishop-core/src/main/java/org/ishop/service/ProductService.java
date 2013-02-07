package org.ishop.service;

import org.ishop.domain.Product;
import org.ishop.domain.Purchase;
import org.ishop.exception.BusinessException;

import javax.ejb.Local;
import java.util.Date;

/**
 * Vouche rservice
 *
 * @author Alexander Burchak
 */
@Local
public interface ProductService {
    /**
     * Save product
     *
     * @param product product
     */
    void save(Product product);

    /**
     * Find product
     *
     * @param id product id
     * @return product or null
     */
    Product getProduct(Long id);

    /**
     * Make purchase
     *
     * @param productId product id
     * @param paymentDate payment date
     * @return purchase
     * @throws BusinessException business error
     */
    Purchase purchase(Long productId, Date paymentDate) throws BusinessException;
}
