package jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Auther: yusiming
 * @Date: 2018/8/7 11:48
 * @Description:
 */
public class Test2 {
    /**
     * @Description: 连接数据库，对数据库进行操作
     * @auther: yusiming
     * @date: 12:53 2018/8/7
     * @param: [args]
     * @return: void
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1?useSSL=false", "root", "314159");
        System.out.println(connection);
        // 得到Statement对象
        Statement statement = connection.createStatement();
        // 使用Statement对象的executeUpdate方法发送sql语句，方法返回影响的行数
        // String sql = "update stu set id='311509030103' where name='虾米'";
        String sql = "delete from stu";
        int i = statement.executeUpdate(sql);
        System.out.println(i);
    }
}
