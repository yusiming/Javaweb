package test.c3p0;

import c3p0.Demo1;
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
     * Method: getConnection1()
     */
    @Test
    public void testGetConnection1() throws Exception {
        Demo1 demo1 = new Demo1();
        Connection connection1 = demo1.getConnection1();
        System.out.println(connection1);
    }

    /**
     * Method: getConnection2()
     */
    @Test
    public void testGetConnection2() throws Exception {
        Demo1 demo1 = new Demo1();
        Connection connection2 = demo1.getConnection2();
        System.out.println(connection2);
    }

    @Test
    public void testGetConnection3() throws Exception {
        Demo1 demo1 = new Demo1();
        Connection connection3 = demo1.getConnection3();
        System.out.println(connection3);
    }
} 
