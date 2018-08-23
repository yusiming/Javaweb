package test.jdbc.thread;

import jdbc.thread.Demo1;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

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
     * Method: fun1()
     */
    @Test
    public void testFun1() throws Exception {
        Demo1 demo1 = new Demo1();
        demo1.fun1();
    }

} 
