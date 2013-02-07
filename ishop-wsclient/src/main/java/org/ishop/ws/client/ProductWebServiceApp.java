package org.ishop.ws.client;

/**
 * Application to access Web service
 *
 * @author Alexander Burchak
 */
public class ProductWebServiceApp {
    public static void main(String args[]) {
        if (args.length != 1) {
            System.err.println("Usage: ProductWebServiceApp <Product ID>");
            return;
        }
        Long productId = Long.parseLong(args[0]);

        Ishop ishop = new ProductWebService().getIshopPort();
        ProductBean product = ishop.getProduct(productId);

        if (product == null) {
            System.out.println("Product ID=" + productId + " not found");
        } else {
            System.out.println("Product ID=" + productId + ":");
            System.out.println("Product code: " + product.getCode());
            System.out.println("Last paid: " + product.getLastPaid());
        }
    }
}
