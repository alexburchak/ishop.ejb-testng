package org.ishop.ws;

/**
 * Product Web service
 *
 * @author Alexander Burchak
 */
public interface ProductWebService {
    /**
     * Get information about product
     *
     * @param id product id
     * @return product bean or null if product was not found
     */
    ProductBean getProduct(long id);
}
