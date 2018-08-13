package jdbc.test;

import dbutils.TxQueryRunner;

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
    public void updateBalance(String name, double number) throws SQLException {
        TxQueryRunner txQueryRunner = new TxQueryRunner();
        String sql = "update account set balance=balance+? where name=?";
        /* 开启事务之后调用JdbcUtilsV2.getConnection()会得到beginTransaction方法赋值的connection对象，
         * 那么就使用的是同一个connection对象，就可以完成事务
         */
        txQueryRunner.update(sql, number, name);
    }
}
