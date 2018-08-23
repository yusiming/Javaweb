package test.dbutils;

import dbutils.QR;
import dbutils.RsHandler;
import dbutils.Student;
import jdbc.utils.JdbcUtilsV2;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * QR Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 9, 2018</pre>
 */
public class QRTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: update(String sql, Object... params)
     */
    @Test
    public void testUpdate() throws Exception {
        QR qr = new QR(JdbcUtilsV2.getDataSource());
        String sql = "DELETE FROM student WHERE sname=?";
        int i = qr.update(sql, "刘德华");
        System.out.println(i);
    }

    /**
     * Method: query(String sql, RsHandler rsHandler, Object params)
     */
    @Test
    public void testQuery() throws Exception {
        DataSource dataSource = JdbcUtilsV2.getDataSource();
        QR<Student> qr = new QR<Student>(dataSource);
        String sql = "select * from student where sname=?";
        //写一个内部类
        RsHandler<Student> rsHandler = new RsHandler<Student>() {
            @Override
            public Student handle(ResultSet resultSet) {
                try {
                    if (!resultSet.next()) {
                        return null;
                    }
                    int sid = resultSet.getInt("sid");
                    String sname = resultSet.getString("sname");
                    Student student = new Student();
                    student.setSid(sid);
                    student.setSname(sname);
                    return student;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Student student = qr.query(sql, rsHandler, "刘德华");
        System.out.println(student.toString());
    }

    /**
     * Method: initParams(PreparedStatement preparedStatement, Object... parems)
     */
    @Test
    public void testInitParams() throws Exception {
//TODO: Test goes here...
    }

} 
