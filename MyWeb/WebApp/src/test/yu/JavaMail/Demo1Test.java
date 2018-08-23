package test.yu.JavaMail;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import yu.JavaMail.Demo1;

public class Demo1Test {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: sendMail()
     */
    @Test
    public void testSendMail() throws Exception {
        Demo1 demo = new Demo1();
        demo.sendMail();
    }

} 
