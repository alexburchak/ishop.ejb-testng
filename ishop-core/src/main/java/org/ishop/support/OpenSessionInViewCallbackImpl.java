package org.ishop.support;

import javax.ejb.Init;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 * Callback implementation to support OpenSessionInView pattern. Have to keep it public for EJB
 *
 * @author Alexander Burchak
 */
@Stateful(name = "openSessionInViewCallback")
public class OpenSessionInViewCallbackImpl implements OpenSessionInViewCallback {
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    @Init
    public void invoke(Runnable r) {
        r.run();
    }

    @Remove
    public void remove() {
    }
}
