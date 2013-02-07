package org.ishop.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;

/**
 * Product entity bean
 *
 * @author Alexander Burchak
 */
@Entity
@Table(name = "product")
@SequenceGenerator(name = "product_generator", sequenceName = "product_seq")
public class Product implements Serializable {
    private static final long serialVersionUID = -2242488915893828569L;

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "product_generator")
    private Long id;

    @Column(name = "code", nullable = false)
    private String code;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Set<Purchase> purchases = new HashSet<Purchase>();

    public Long getId() {
        return id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public Set<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }

    public void addPurchase(Purchase purchase) {
        this.purchases.add(purchase);
    }
}
