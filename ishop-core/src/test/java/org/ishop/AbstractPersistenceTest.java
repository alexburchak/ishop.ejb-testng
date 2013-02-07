package org.ishop;

import org.testng.annotations.BeforeClass;

import javax.naming.*;
import java.io.IOException;
import java.util.Properties;

/**
 * Base class for all persistence-based tests
 *
 * @author Alexander Burchak
 */
public abstract class AbstractPersistenceTest {
    private Context context;

    @BeforeClass(groups = "database")
    public final void setUpDatabase() throws NamingException, IOException {
        Properties props = new Properties();
        props.load(AbstractPersistenceTest.class.getResourceAsStream("/persistence.properties"));
        context = new InitialContext(props);
    }

    /**
     * Get bean by JNDI name
     *
     * @param name JNDI name
     * @return bean
     * @throws NamingException bean not found
     */
    @SuppressWarnings("unchecked")
    protected final <T> T lookup(String name) throws NamingException {
        return (T) context.lookup(name);
    }
}
