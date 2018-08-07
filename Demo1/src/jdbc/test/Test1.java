package jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Auther: yusiming
 * @Date: 2018/8/7 10:40
 * @Description:
 */
public class Test1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /*
         * java四大配置参数：
         * driverClassName: com.mysql.jdbc.Driver ,这个类在新版本已经弃用,取而代之的是com.mysql.cj.jdbc.Driver
         * url: jdbc:mysql://localhost:3306/数据库名
         * username: root
         * password: 314159
         */
        //加载驱动类.(注册驱动),所有的java.sql.Driver的实现类都提供了static代码块，把自己注册到DriverManager中
        Class.forName("com.mysql.cj.jdbc.Driver");
        //得到连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1?useSSL=false", "root", "314159");
        System.out.println(connection);
    }
}
