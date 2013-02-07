package org.ishop.ws;

import java.io.Serializable;
import java.util.Date;

/**
 * Product bean
 *
 * @author Alexander Burchak
 */
public class ProductBean implements Serializable {
    private static final long serialVersionUID = -7087306185852703999L;

    private long id;

    private String code;

    private Date lastPaid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getLastPaid() {
        return lastPaid;
    }

    public void setLastPaid(Date lastPaid) {
        this.lastPaid = lastPaid;
    }
}
