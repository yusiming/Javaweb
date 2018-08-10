package dbutils;

import jdbc.utils.JdbcUtilsV2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Auther: yusiming
 * @Date: 2018/8/9 20:59
 * @Description: commons-dbutils,简化jdbc的代码
 */
public class Demo1 {
    public void addStu(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtilsV2.getConnection();
            preparedStatement = connection.prepareStatement("insert into student values(?,?)");
            preparedStatement.setInt(1,student.getSid());
            preparedStatement.setString(2,student.getSname());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
        }
    }
}
