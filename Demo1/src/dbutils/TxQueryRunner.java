package dbutils;

import jdbc.utils.JdbcUtilsV2;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Auther: yusiming
 * @Date: 2018/8/13 10:42
 * @Description: 重写QueryRunner的部分方法，实现代码的简化
 */
public class TxQueryRunner extends QueryRunner {
    /**
     * @Description: 重写父类中参数没有connection的方法，使用JdbcUtilsV2向方法中传递connection对象，
     * 然后再调用父类中比此方法多一个connection对象的方法，完成对方法的重写
     * @auther: yusiming
     * @date: 11:00 2018/8/13
     * @param: [sql, params]
     * @return: int[]
     */
    @Override
    public int[] batch(String sql, Object[][] params) throws SQLException {
        // 得到连接对象
        Connection connection = JdbcUtilsV2.getConnection();
        //调用父类connection的方法，传递连接对象
        int[] result = super.batch(connection, sql, params);
        // 释放连接，
        JdbcUtilsV2.releaseConnection(connection);
        // 返回值
        return result;
    }

    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
        Connection connection = JdbcUtilsV2.getConnection();
        T result = super.query(connection, sql, rsh, params);
        JdbcUtilsV2.releaseConnection(connection);
        return result;
    }

    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
        Connection connection = JdbcUtilsV2.getConnection();
        T result = super.query(connection, sql, rsh);
        JdbcUtilsV2.releaseConnection(connection);
        return result;
    }

    @Override
    public int update(String sql) throws SQLException {
        Connection connection = JdbcUtilsV2.getConnection();
        int result = super.update(connection, sql);
        JdbcUtilsV2.releaseConnection(connection);
        return result;
    }

    @Override
    public int update(String sql, Object param) throws SQLException {
        Connection connection = JdbcUtilsV2.getConnection();
        int result = super.update(connection, sql, param);
        JdbcUtilsV2.releaseConnection(connection);
        return result;
    }

    @Override
    public int update(String sql, Object... params) throws SQLException {
        Connection connection = JdbcUtilsV2.getConnection();
        int result = super.update(connection, sql, params);
        JdbcUtilsV2.releaseConnection(connection);
        return result;
    }
}
