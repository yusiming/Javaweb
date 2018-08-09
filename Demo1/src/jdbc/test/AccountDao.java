package jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Auther: yusiming
 * @Date: 2018/8/9 10:28
 * @Description: 修改指定用户的账户余额
 */
public class AccountDao {
    /**
     * @Description: 谁调用这个方法必须向它传递Connection对象参数
     * @auther: yusiming
     * @date: 11:02 2018/8/9
     * @param: [connection, name, number]
     * @return: void
     */
    public void updateBalance(Connection connection, String name, double number) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update account set balance=balance+? where name=?");
            preparedStatement.setDouble(1, number);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
