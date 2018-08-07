package jdbc.test;

import java.sql.*;

/**
 * @Auther: yusiming
 * @Date: 2018/8/7 15:29
 * @Description:
 */
public class Test5 {
    /**
     *
     * @Description:
     * 使用try-with-resources语句，自动管理资源
     * @auther: yusiming
     * @date: 15:34 2018/8/7
     * @param: [args]
     * @return: void
     *
     */
    public static void main(String[] args) throws  ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (//连接数据库
             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam?useSSL=false", "root", "314159");
             //得到statement对象
             Statement statement = connection.createStatement();
             //发送查询语句,得到结果集
             ResultSet resultSet = statement.executeQuery("select * from exam.emp")) {
            //移动到最后一行
            resultSet.last();
            //输出行数
            System.out.println(resultSet.getRow());
            //移动到第一行，不然无法打印数据
            resultSet.first();
            //得到元数据，再得到列数
            int columnCount = resultSet.getMetaData().getColumnCount();
            //遍历输出结果集
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getObject(i));
                    if (i < columnCount) System.out.print(", ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
