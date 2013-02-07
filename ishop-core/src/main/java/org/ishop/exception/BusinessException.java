package org.ishop.exception;

import javax.ejb.ApplicationException;

/**
 * Business exception
 *
 * @author Alexander Burchak
 */
@ApplicationException(rollback = true)
public class BusinessException extends Exception {
    private static final long serialVersionUID = -7719588120331592228L;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
