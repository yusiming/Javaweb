package jdbc.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Auther: yusiming
 * @Date: 2018/8/9 15:45
 * @Description:
 */
public class JdbcUtilsV2 {
    // 使用默认配置创建连接池对象
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
    // 声明一个私有的Connection对象，事务专用
    private static Connection connection = null;

    /**
     * @Description: 使用连接池对象创建一个Connection对象
     * @auther: yusiming
     * @date: 15:48 2018/8/9
     * @param: []
     * @return: java.sql.Connection
     */
    public static Connection getConnection() throws SQLException {
        // 当开始事务时，connection已经被赋值，调用这个方法的dao会得到已经赋值的connection
        if (connection != null) {
            return connection;
        }
        return dataSource.getConnection();
    }

    /**
     * @Description: 返回一个连接池对象
     * @auther: yusiming
     * @date: 15:55 2018/8/9
     * @param: []
     * @return: javax.sql.DataSource
     */
    public static DataSource getDataSource() {
        return dataSource;
    }

    /**
     * @Description: 开始事务，使用事务专用的connection
     * @auther: yusiming
     * @date: 20:41 2018/8/10
     * @param: []
     * @return: void
     */
    public static void beginTransaction() throws SQLException {
        // 给事务专用connection对象赋值
        connection = getConnection();
        // 开启事务
        connection.setAutoCommit(false);
    }

    /**
     * @Description: 使用事务专用的connection，提交事务
     * @auther: yusiming
     * @date: 20:42 2018/8/10
     * @param: []
     * @return: void
     */
    public static void commitTransaction() throws SQLException {
        connection.commit();
        connection.close();
    }

    /**
     * @Description: 使用事务专用的connection，回滚事务
     * @auther: yusiming
     * @date: 20:42 2018/8/10
     * @param: []
     * @return: void
     */
    public static void rollbackTransaction() throws SQLException {
        connection.rollback();
        connection.close();
    }
}
