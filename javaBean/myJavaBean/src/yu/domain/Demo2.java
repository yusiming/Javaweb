package yu.domain;

import yu.utils.CommonUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: yusiming
 * @Date: 2018/7/30 16:26
 * @Description:
 */
public class Demo2 {
    public static void main(String[] args) throws Exception {
        Map<String,String> map = new HashMap<String, String>();
        map.put("name","虞小明");
        map.put("age","20");
        map.put("sex","男");
        Person person = CommonUtils.toBean(map,Person.class);
        System.out.println(person);
    }
}
