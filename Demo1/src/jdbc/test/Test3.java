package jdbc.test;

import java.sql.*;

/**
 * @Auther: yusiming
 * @Date: 2018/8/7 13:11
 * @Description:
 */
public class Test3 {
    /**
     * @Description: 查询数据
     * @auther: yusiming
     * @date: 13:12 2018/8/7
     * @param: [args]
     * @return: void
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 加载驱动类
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 得到Connection对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam?useSSL=false", "root", "314159");
        // 得到Statement对象
        Statement statement = connection.createStatement();
        // 查询exam数据库
        String sql = "select * from emp";
        // 返回一个结果集对象
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println(resultSet);
        // 解析ResultSet对象
        while (resultSet.next()) {
            int empno = resultSet.getInt(1);
            String ename = resultSet.getString("ename");
            double sal = resultSet.getDouble("sal");
            System.out.println(empno + "," + ename + "," + sal);
        }
        // 关闭资源,倒序关闭
        resultSet.close();
        statement.close();
        connection.close();
    }
}
