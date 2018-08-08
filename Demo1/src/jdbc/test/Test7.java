package jdbc.test;

import jdbc.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @Auther: yusiming
 * @Date: 2018/8/8 16:24
 * @Description: 演示批处理
 */
public class Test7 {
    public static void main(String[] args) throws Exception {
        Connection connection = JdbcUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into stu values(?,?,?,?)");
        for (int i = 0; i < 10000; i++) {
            preparedStatement.setInt(1, i);
            preparedStatement.setString(2, "student" + i);
            preparedStatement.setInt(3,i);
            preparedStatement.setString(4, i % 2 == 0 ? "男" : "女");
            preparedStatement.addBatch();
        }
        long currentTimeMillis = System.currentTimeMillis();
        preparedStatement.executeBatch();
        long newCurrentTimeMillis = System.currentTimeMillis();
        System.out.println(newCurrentTimeMillis - currentTimeMillis);
    }
}
