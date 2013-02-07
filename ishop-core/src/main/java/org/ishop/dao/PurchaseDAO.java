package org.ishop.dao;

import org.ishop.domain.Purchase;

import javax.ejb.Local;

/**
 * Purchase DAO
 *
 * @author Alexander Burchak
 */
@Local
public interface PurchaseDAO extends DAO<Purchase> {
}
