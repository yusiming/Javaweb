package c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Auther: yusiming
 * @Date: 2018/8/9 15:00
 * @Description: 使用c3p0
 */
public class Demo1 {
    /**
     * @Description: 手动配置参数
     * @auther: yusiming
     * @date: 15:25 2018/8/9
     * @param: []
     * @return: java.sql.Connection
     */
    public Connection getConnection1() throws PropertyVetoException, SQLException {
        //创建连接池对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        //配置四大参数
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mydb1?useSSL=false");
        dataSource.setUser("root");
        dataSource.setPassword("314159");

        //配置池参数
        dataSource.setAcquireIncrement(5);
        dataSource.setInitialPoolSize(20);
        dataSource.setMinPoolSize(5);
        dataSource.setMaxPoolSize(50);

        //得到Connection对象
        Connection connection = dataSource.getConnection();
        //把连接归还给池
        //connection.close();
        return connection;
    }

    /**
     * @Description: 使用默认配置
     * @auther: yusiming
     * @date: 15:36 2018/8/9
     * @param: []
     * @return: java.sql.Connection
     */
    public Connection getConnection2() throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        return dataSource.getConnection();
    }

    /**
     * @Description: 使用指定配置
     * @auther: yusiming
     * @date: 15:37 2018/8/9
     * @param: []
     * @return: java.sql.Connection
     */
    public Connection getConnection3() throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql-config");
        return dataSource.getConnection();
    }
}
