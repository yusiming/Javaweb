package dbutils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // 调用本类的initParams方法，设置参数
            this.initParams(preparedStatement, params);
            // 返回影响的行数
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description: 所有的查询数据库操作使用这个方法来完成，该方法返回一个bean对象，RsHandler由调用这个方法的提供
     * @auther: yusiming
     * @date: 11:40 2018/8/10
     * @param: [sql, rsHandler, params]
     * @return: T
     */
    public T query(String sql, RsHandler<T> rsHandler, Object params) {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // 设置参数
            this.initParams(preparedStatement, params);
            // 得到结果集
            ResultSet resultSet = preparedStatement.executeQuery();
            // 使用传递进来的rsHandler的handle方法返一个bean对象
            return rsHandler.handle(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
