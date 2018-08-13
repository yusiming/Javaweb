package jdbc.demo;

import jdbc.test.AccountDao;
import jdbc.utils.JdbcUtilsV2;

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
        try {
            // 开启事务
            JdbcUtilsV2.beginTransaction();
            // 执行转账操作
            accountDao.updateBalance(from, -money);
            accountDao.updateBalance(to, money);
            // 提交事务
            JdbcUtilsV2.commitTransaction();
        } catch (Exception e) {
            try {
                JdbcUtilsV2.rollbackTransaction();
            } catch (SQLException e1) {
                throw new RuntimeException(e);
            }
        }
    }
}
