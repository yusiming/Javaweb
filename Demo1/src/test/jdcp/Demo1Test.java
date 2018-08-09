package test.jdcp;

import jdcp.Demo1;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.sql.Connection;

/**
 * Demo1 Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 9, 2018</pre>
 */
public class Demo1Test {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getConnectionFromPool()
     */
    @Test
    public void testGetConnectionFromPool() throws Exception {
        Demo1 demo1 = new Demo1();
        Connection connectionFromPool = demo1.getConnectionFromPool();
        connectionFromPool.close();
    }

} 
