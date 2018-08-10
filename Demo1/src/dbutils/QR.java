package dbutils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Auther: yusiming
 * @Date: 2018/8/9 21:15
 * @Description:
 */
public class QR<T> {
    private DataSource dataSource;

    public QR() {
    }

    public QR(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int update(String sql, Object... params) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            this.initParams(preparedStatement, params);
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public T query(String sql, RsHandler rsHandler, Object params) {
        return null;
    }

    private void initParams(PreparedStatement preparedStatement, Object... parems) {
        for (int i = 0; i < parems.length; i++) {
            try {
                preparedStatement.setObject(i + 1, parems[i]);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
