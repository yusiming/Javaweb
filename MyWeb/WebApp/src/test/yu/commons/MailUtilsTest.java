package test.yu.commons;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import yu.commons.MailUtils;

public class MailUtilsTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: sendMail(String destination)
     */
    @Test
    public void testSendMail() throws Exception {
        MailUtils.sendMail("13966931523@163.com");
    }

    @Test
    public void sendMailWithFile() throws Exception {
        MailUtils.sendMailWithFile("13966931523@163.com");
    }

    /**
     * Method: getSession()
     */
    @Test
    public void testGetSession() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = MailUtils.getClass().getMethod("getSession"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

} 
