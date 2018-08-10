package dbutils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Auther: yusiming
 * @Date: 2018/8/9 21:15
 * @Description: 简化jdbc的代码量
 */
public class QR<T> {
    private DataSource dataSource;

    public QR(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * @Description: 所有的对数据库的增、删、改都可以使用一个方法来完成
     * @auther: yusiming
     * @date: 11:34 2018/8/10
     * @param: [sql, params]
     * @return: int
     */
    public int update(String sql, Object... params) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // 调用本类的initParams方法，设置参数
            this.initParams(preparedStatement, params);
            // 返回影响的行数
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public T query(String sql, RsHandler rsHandler, Object params) {
        return null;
    }

    /**
     * @Description: 实现对PreparedStatement的参数设置的方法
     * @auther: yusiming
     * @date: 11:35 2018/8/10
     * @param: [preparedStatement, parems]
     * @return: void
     */
    private void initParams(PreparedStatement preparedStatement, Object... parems) {
        // 循环遍历可变参数parems，一次向preparedStatement 中设置值
        for (int i = 0; i < parems.length; i++) {
            try {
                // 由于不知道设置的是什么类型，所以使用setObject
                preparedStatement.setObject(i + 1, parems[i]);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
