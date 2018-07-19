package test.DebugTest;

import DebugTest.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Person Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÆßÔÂ 19, 2018</pre>
 */
public class PersonTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: main(String[] args)
     */
    @Test
    public void testMain() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: add(int a, int b)
     */
    @Test
    public void testAdd() throws Exception {
        Person person = new Person();
        person.add(1,2);
    }

} 
