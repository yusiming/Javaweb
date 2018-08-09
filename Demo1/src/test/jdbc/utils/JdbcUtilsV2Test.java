package test.jdbc.utils;

import jdbc.utils.JdbcUtilsV2;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * JdbcUtilsV2 Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 9, 2018</pre>
 */
public class JdbcUtilsV2Test {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getConnection()
     */
    @Test
    public void testGetConnection() throws Exception {
        Connection connection = JdbcUtilsV2.getConnection();
        System.out.println(connection);
    }

    /**
     * Method: getDataSource()
     */
    @Test
    public void testGetDataSource() throws Exception {
        DataSource dataSource = JdbcUtilsV2.getDataSource();
        System.out.println(dataSource);
    }

} 
