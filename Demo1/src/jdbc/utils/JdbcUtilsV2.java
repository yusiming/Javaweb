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
    //使用默认配置创建连接池对象
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    /**
     * @Description: 使用连接池对象创建一个Connection对象
     * @auther: yusiming
     * @date: 15:48 2018/8/9
     * @param: []
     * @return: java.sql.Connection
     */
    public static Connection getConnection() throws SQLException {
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
}
