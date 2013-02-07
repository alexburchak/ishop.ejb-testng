package org.ishop.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Purchase
 *
 * @author Alexander Burchak
 */
@Entity
@Table(name = "purchase")
@SequenceGenerator(name = "purchase_generator", sequenceName = "purchase_seq")
public class Purchase implements Serializable {
    private static final long serialVersionUID = -5217694148760063305L;

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "purchase_generator")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "payment_date", nullable = false)
    private Date paymentDate;

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
