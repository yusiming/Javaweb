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
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    /**
     * @Description: 使用连接池对象创建一个Connection对象
     * @auther: yusiming
     * @date: 15:48 2018/8/9
     * @param: []
     * @return: java.sql.Connection
     */
    public static Connection getConnection() throws SQLException {
        // 在threadLocal中获取连接，
        Connection connection = threadLocal.get();
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
        Connection connection = threadLocal.get();
        // 判断事务是否已经开启，若已经开启，抛出异常
        if (connection != null) {
            throw new SQLException("已经开启事务，勿重复开启");
        }
        // 给事务专用connection对象赋值
        connection = getConnection();
        // 开启事务
        connection.setAutoCommit(false);
        // 向threadLocal中设置事务专用连接
        threadLocal.set(connection);
    }

    /**
     * @Description: 使用事务专用的connection，提交事务
     * @auther: yusiming
     * @date: 20:42 2018/8/10
     * @param: []
     * @return: void
     */
    public static void commitTransaction() throws SQLException {
        Connection connection = threadLocal.get();
        // 判断事务是否已经开启,若未开启不能调用此方法，防止空指针异常
        if (connection == null) {
            throw new SQLException("未开启事务，请开启事务再调用此方法");
        }
        connection.commit();
        connection.close();
        /* 表示事务已经结束,设置为null的原因是，若不设置为null，
         * getConnection方法得到的connection只能是beginTransaction方法中设置的connection
         */
        threadLocal.remove();
    }

    /**
     * @Description: 使用事务专用的connection，回滚事务
     * @auther: yusiming
     * @date: 20:42 2018/8/10
     * @param: []
     * @return: void
     */
    public static void rollbackTransaction() throws SQLException {
        Connection connection = threadLocal.get();
        // 判断事务是否已经开启，若未开启不能调用此方法，防止空指针异常
        if (connection == null) {
            throw new SQLException("未开启事务，请开启事务再调用此方法");
        }
        connection.rollback();
        connection.close();
        // 表示事务已经结束
        threadLocal.remove();
    }

    /**
     * @Description: 释放连接的方法，判断con是否是事务专用的connection，若不是则关闭此连接
     * @auther: yusiming
     * @date: 21:11 2018/8/11
     * @param: [connection]
     * @return: void
     */
    public static void releaseConnection(Connection con) throws SQLException {
        Connection connection = threadLocal.get();
        // 若connection为空证明没有开启事务，直接关闭con
        if (connection == null) {
            con.close();
        }
        // 若某一dao在事务开启之前，已经调用getConnection方法得到了Connection对象，那么需要判断con是否与connection相等，
        if (con != connection) {
            con.close();
        }
    }
}
