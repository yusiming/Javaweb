package jdbc.demo;

import jdbc.test.AccountDao;
import jdbc.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Auther: yusiming
 * @Date: 2018/8/9 10:27
 * @Description: 使用jdbc实现事务处理
 */
public class Demo1 {
    private AccountDao accountDao = new AccountDao();

    /**
     * @Description: 转账方法
     * @auther: yusiming
     * @date: 10:44 2018/8/9
     * @param: [from, to, money]
     * @return: void
     */
    public void transferAccount(String from, String to, double money) {
        Connection connection = null;
        try {
            //得到Connection对象
            connection = JdbcUtils.getConnection();
            //开启事务
            connection.setAutoCommit(false);
            //从from用户减少金额
            accountDao.updateBalance(connection, from, -money);
            //向to用户增加金额
            accountDao.updateBalance(connection, to, money);
            //结束事务
            connection.commit();
            connection.close();
        } catch (Exception e) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            throw new RuntimeException(e);
        }
    }
}
