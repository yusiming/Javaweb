package yu.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;
import java.util.UUID;

/**
 * @Auther: yusiming
 * @Date: 2018/7/30 16:11
 * @Description: 工具类
 */
public class CommonUtils {
    /**
     * @Description: 该方法返回一个32位字长的大写的不重复的字符串
     * @auther: yusiming
     * @date: 16:13 2018/7/30
     * @param: []
     * @return: java.lang.String
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    public static <T> T toBean(Map map, Class<T> clazz) {
        try {
            //创建指定类型的JavaBean对象
            T bean = (T) clazz.getDeclaredConstructor().newInstance();
            //使用BeanUtils,把数据封装到Bean对象中
            BeanUtils.populate(bean,map);
            //返回Bean对象
            return bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
