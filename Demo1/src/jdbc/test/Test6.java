package jdbc.test;

import java.sql.*;

/**
 * @Auther: yusiming
 * @Date: 2018/8/7 20:39
 * @Description: 模拟SQL攻击
 */
public class Test6 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String sqlUsername = "any' or 'a'='a";
        String sqlPassword = "any' or 'a'='a";
        System.out.println(login(sqlUsername, sqlPassword));
    }

    /**
     * @Description: 实现一个登陆方法，登陆成功返回true，失败返回false
     * @auther: yusiming
     * @date: 20:50 2018/8/7
     * @param: [username, password]
     * @return: boolean
     */
    public static boolean login(String username, String password) throws ClassNotFoundException, SQLException {
        //加载驱动类.(注册驱动),所有的java.sql.Driver的实现类都提供了static代码块，把自己注册到DriverManager中
        Class.forName("com.mysql.cj.jdbc.Driver");
        //得到连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1?useSSL=false", "root", "314159");
        Statement statement = connection.createStatement();
        System.out.println("select * from user where username='" + username + "' and password='" + password + "'");
        //根据参数查询用户名密码是否正确
        ResultSet resultSet = statement.executeQuery("select * from user where username='" + username + "' and password='" + password + "'");
        return resultSet.next();
    }
}
