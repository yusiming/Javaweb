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
        System.out.println(login1(sqlUsername, sqlPassword));
        System.out.println(login2(sqlUsername, sqlPassword));
    }

    /**
     * @Description: 实现一个登陆方法，登陆成功返回true，失败返回false
     * @auther: yusiming
     * @date: 20:50 2018/8/7
     * @param: [username, password]
     * @return: boolean
     */
    private static boolean login1(String username, String password) throws ClassNotFoundException, SQLException {
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

    /**
     * @Description: 使用PreparedStatement来防止sql攻击
     * @auther: yusiming
     * @date: 21:55 2018/8/7
     * @param: [username, password]
     * @return: boolean
     */
    private static boolean login2(String username, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1?useSSL=false", "root", "314159");
        //给出sql模板
        String sql = "select * from user where username=? and password=?";
        //得到PreparedStatement对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //给第一个问号赋值
        preparedStatement.setString(1, username);
        //给第二个问号赋值
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }
}
