package yu.domain;

import org.apache.commons.beanutils.BeanUtils;

/**
 * @Auther: yusiming
 * @Date: 2018/7/30 15:50
 * @Description:
 */
public class Demo1 {
    /**
     * @Description: 使用BeanUtils工具包操作JavaBean
     * @auther: 虞四明
     * @date: 15:59 2018/7/30
     * @param: [args]
     * @return: void
     */
    public static void main(String[] args) throws Exception {
        Class aClass = Class.forName("yu.domain.Person");
        Object person = aClass.getDeclaredConstructor().newInstance();
        BeanUtils.setProperty(person, "name", "虞四明");
        BeanUtils.setProperty(person, "age", 20);
        BeanUtils.setProperty(person, "sex", "男");
        System.out.println(person.toString());
    }
}
