package jdcp;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Auther: yusiming
 * @Date: 2018/8/9 13:09
 * @Description: DBCP连接池
 */
public class Demo1 {
    public Connection getConnectionFromPool() {
        //创建连接池对象
        BasicDataSource dataSource = new BasicDataSource();

        //配置连接参数
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mydb1?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("314159");

        //配置池参数，最大活动链接数为20
        dataSource.setMaxActive(20);
        //最小空闲参数
        dataSource.setMinIdle(3);
        //最大等待时间，超出时间抛出异常
        dataSource.setMaxWait(1000);

        //得到连接对象
        Connection hhConnection = null;
        try {
            Connection connection = dataSource.getConnection();
            //进一步装饰
            hhConnection = new MyConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //如果执行了下面这一步，返回的connection为null，
        /*try {
            //把Connection对象归还给连接池
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        return hhConnection;
    }
}
