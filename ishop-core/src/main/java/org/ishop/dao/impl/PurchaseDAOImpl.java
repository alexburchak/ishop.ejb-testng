package org.ishop.dao.impl;

import org.ishop.dao.PurchaseDAO;
import org.ishop.domain.Purchase;

import javax.ejb.Stateless;

/**
 * {@link PurchaseDAO} implementation
 *
 * @author Alexander Burchak
 */
@Stateless(name = "purchaseDAO")
public class PurchaseDAOImpl extends AbstractDAO<Purchase> implements PurchaseDAO {
    public PurchaseDAOImpl() {
        super(Purchase.class);
    }
}