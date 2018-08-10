package dbutils;

import java.sql.ResultSet;

/**
 * @Auther: yusiming
 * @Date: 2018/8/9 21:18
 * @Description:
 */
public interface RsHandler<T> {
    T handle(ResultSet resultSet);
}
