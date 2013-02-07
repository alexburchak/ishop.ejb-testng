package org.ishop.dao;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.ishop.AbstractPersistenceTest;
import org.ishop.domain.Product;

import javax.naming.NamingException;

/**
 * Test for {ProductDAO}
 *
 * @author Alexander Burchak
 */
public class ProductDAOTest extends AbstractPersistenceTest {
    private ProductDAO productDAO;

    private Product product;

    @BeforeClass(groups = "database")
    public void setUpDAO() throws NamingException {
        productDAO = lookup("productDAOLocal");
    }

    @BeforeMethod(groups = "database")
    public void createProduct() {
        product = new Product();
        product.setCode("ABCDEF");
    }

    @Test(groups = "database")
    public void testSave() {
        productDAO.save(product);

        Assert.assertNotNull(product.getId());
    }

    @Test(groups = "database")
    public void testGet() {
        productDAO.save(product);

        Product copy = productDAO.get(product.getId());

        Assert.assertNotNull(copy);
        Assert.assertEquals(copy.getId(), product.getId());
        Assert.assertEquals(copy.getCode(), product.getCode());

        copy = productDAO.get(product.getId() + 1);

        Assert.assertNull(copy);
    }
}
