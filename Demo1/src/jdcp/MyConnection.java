package jdcp;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Auther: yusiming
 * @Date: 2018/8/9 14:33
 * @Description:
 */
public class MyConnection extends ConnectionWrapper {
    public MyConnection(Connection con) {
        super(con);
    }
    public void close() throws SQLException {
        System.out.println("哈哈");
        super.close();
    }
}
