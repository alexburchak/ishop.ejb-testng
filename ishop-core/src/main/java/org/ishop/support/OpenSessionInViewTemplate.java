package org.ishop.support;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Template to support OpenSessionInView pattern
 *
 * @author Alexander Burchak
 */
public final class OpenSessionInViewTemplate {
    public static void invoke(Runnable r) {
        OpenSessionInViewCallback callback = null;
        try {
            // make lookup for callback bean
            Context context = new InitialContext();
            callback = (OpenSessionInViewCallback) context.lookup("openSessionInViewCallbackLocal");

            // invoke runnable
            callback.invoke(r);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        } finally {
            if (callback != null) {
                // remove bean
                callback.remove();
            }
        }
    }
}
