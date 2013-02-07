package org.ishop.support;

import javax.ejb.Local;

/**
 * Callback to support OpenSessionInView pattern
 *
 * @author Alexander Burchak
 */
@Local
interface OpenSessionInViewCallback {
    /**
     * Invoke runnable in template
     *
     * @param r {@link Runnable} to invoke
     */
    void invoke(Runnable r);

    /**
     * This method is for internal use by {@link OpenSessionInViewTemplate}
     */
    void remove();
}
