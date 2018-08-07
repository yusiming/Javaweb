package jdbc.test;

import java.sql.*;

/**
 * @Auther: yusiming
 * @Date: 2018/8/7 13:46
 * @Description: 代码的规范化
 */
public class Test4 {
    //实现代码的规范化
    public static void main(String[] args) throws SQLException {
        //先声明对象，不然在其他代码块无法使用这些对象
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //连接数据库
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam?useSSL=false", "root", "314159");
            //得到statement对象
            statement = connection.createStatement();
            //发送查询语句
            resultSet = statement.executeQuery("select * from exam.emp");
            //遍历输出结果集
            while (resultSet.next()) {
                int empno = resultSet.getInt("empno");
                String ename = resultSet.getString("ename");
                double sal = resultSet.getDouble("sal");
                System.out.println(empno + "," + ename + "," + sal);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
