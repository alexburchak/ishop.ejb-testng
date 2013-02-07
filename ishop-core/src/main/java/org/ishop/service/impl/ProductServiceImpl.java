package org.ishop.service.impl;

import org.ishop.service.ProductService;
import org.ishop.domain.Product;
import org.ishop.domain.Purchase;
import org.ishop.dao.ProductDAO;
import org.ishop.dao.PurchaseDAO;
import org.ishop.exception.BusinessException;

import javax.ejb.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * {@link ProductService} implementation
 *
 * @author Alexander Burchak
 */
@TransactionManagement
@Stateless(name = "productService", mappedName = "productService")
public class ProductServiceImpl implements ProductService {
    @EJB
    private ProductDAO productDAO;
    @EJB
    private PurchaseDAO purchaseDAO;

    @TransactionAttribute
    public void save(Product product) {
        productDAO.save(product);
    }

    @TransactionAttribute
    public Product getProduct(Long id) {
        return productDAO.get(id);
    }

    @TransactionAttribute
    public Purchase purchase(Long productId, Date paymentDate) throws BusinessException {
        Product product = productDAO.get(productId);
        if (product == null) {
            throw new IllegalArgumentException("Invalid product id: " + productId);
        }

        Purchase purchase = new Purchase();
        purchase.setPaymentDate(paymentDate);
        purchase.setProduct(product);

        product.addPurchase(purchase);

        purchaseDAO.save(purchase);
        productDAO.save(product);

        try {
            if (paymentDate.before(new SimpleDateFormat("dd.MM.yyyy").parse("01.01.2000"))) {
                // this will automatically rollback the transaction
                throw new BusinessException("Invalid date: " + paymentDate);
            }
        } catch (ParseException e) {
            throw new RuntimeException("Not expected", e);
        }

        return purchase;
    }
}
