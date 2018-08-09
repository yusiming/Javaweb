package test.jdbc.utils; 

import jdbc.utils.JdbcUtils;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.sql.Connection;

/** 
* JdbcUtils Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 8, 2018</pre> 
* @version 1.0 
*/ 
public class JdbcUtilsTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getConnection() 
* 
*/ 
@Test
public void testGetConnection() throws Exception {
    Connection connection = JdbcUtils.getConnection();
    System.out.println(connection);
} 


} 
