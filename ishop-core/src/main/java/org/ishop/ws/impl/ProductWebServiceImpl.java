package org.ishop.ws.impl;

import org.ishop.ws.ProductWebService;
import org.ishop.ws.ProductBean;
import org.ishop.domain.Product;
import org.ishop.domain.Purchase;
import org.ishop.service.ProductService;
import org.jboss.wsf.spi.annotation.WebContext;
import org.jboss.annotation.ejb.RemoteBinding;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;
import javax.ejb.*;
import java.util.Date;

/**
 * Product Web service implementation
 *
 * @author Alexander Burchak
 */
@WebService(name = "ishop",
        targetNamespace = "http://ishop.org",
        serviceName = "productWebService")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@WebContext(contextRoot = "/ishop-ws", urlPattern = "/productWebService")
@Remote(ProductWebService.class)
@RemoteBinding(jndiBinding = "productWebServiceRemote")
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ProductWebServiceImpl implements ProductWebService {
    @EJB
    private ProductService productService;

    @WebMethod
    public ProductBean getProduct(@WebParam(name = "id") long id) {
        ProductBean bean = null;

        Product product = productService.getProduct(id);
        if (product != null) {
            bean = new ProductBean();
            bean.setId(product.getId());
            bean.setCode(product.getCode());
            Date lastPaid = null;
            for (Purchase purchase : product.getPurchases()) {
                if (lastPaid == null || lastPaid.after(purchase.getPaymentDate())) {
                    lastPaid = purchase.getPaymentDate();
                }
            }
            bean.setLastPaid(lastPaid);
        }
        return bean;
    }
}
