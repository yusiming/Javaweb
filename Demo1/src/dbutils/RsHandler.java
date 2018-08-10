package dbutils;

import java.sql.ResultSet;

/**
 * @Auther: yusiming
 * @Date: 2018/8/9 21:18
 * @Description:
 */
public interface RsHandler<T> {
    public T handle(ResultSet resultSet);
}
