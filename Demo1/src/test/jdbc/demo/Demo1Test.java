package test.jdbc.demo;

import jdbc.demo.Demo1;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class Demo1Test {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: transferAccount(String from, String to, double money)
     */
    @Test
    public void testTransferAccount() throws Exception {
        Demo1 demo1 = new Demo1();
        demo1.transferAccount("zs", "ls", 100);
    }

} 
