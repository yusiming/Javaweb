package yu.commons;

import java.util.UUID;

/**
 * @Auther: yusiming
 * @Date: 2018/7/27 15:56
 * @Description:
 */
public class CommonUtils {
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-","").toUpperCase();
    }
}
