package jdbc.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * v1.0
 *
 * @Auther: yusiming
 * @Date: 2018/8/8 07:56
 * @Description: 通过读取配置文件，获取参数，创建Connection对象
 */
public class JdbcUtils {
    // 如果不是static类型，下面的properties = new Properties();无法生效，而且不能放在static块中
    private static Properties properties = null;

    static {
        // 加载配置文件，这段代码只会在类被加载时，执行一次
        InputStream resourceAsStream = JdbcUtils.class.getClassLoader().getResourceAsStream("databaseConfig.properties");
        properties = new Properties();
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 加载驱动类
        try {
            Class.forName(properties.getProperty("driverClassName"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        // 得到connection对象
        return DriverManager.getConnection(properties.getProperty("url"),
                properties.getProperty("username"),
                properties.getProperty("password"));
    }
}
