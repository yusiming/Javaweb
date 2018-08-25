package test.yu.jsonLib;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import yu.jsonLib.Demo1;

/**
 * Demo1 Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 25, 2018</pre>
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

    @Test
    public void testFun2() throws Exception {
        Demo1 demo1 = new Demo1();
        demo1.fun2();
    }

    @Test
    public void testFun3() throws Exception {
        Demo1 demo1 = new Demo1();
        demo1.fun3();
    }

    @Test
    public void testFun4() throws Exception {
        Demo1 demo1 = new Demo1();
        demo1.fun4();
    }
} 
