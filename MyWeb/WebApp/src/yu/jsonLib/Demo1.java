package yu.jsonLib;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: yusiming
 * @Date: 2018/8/25 11:42
 * @Description: JsonLib小工具
 */
public class Demo1 {
    public void fun1() {
        JSONObject map = new JSONObject();
        map.put("name","虞四明");
        map.put("age",18);
        map.put("sex","男");
        System.out.println(map.toString());
    }
    public void fun2() {
        JSONObject map = new JSONObject();
        Person p1 = new Person("张三",20,"男");
        // 将对象转换为JSONObject对象
        JSONObject jsonObject = JSONObject.fromObject(p1);
        System.out.println(jsonObject.toString());
    }

    public void fun3() {
        JSONArray jsonArray = new JSONArray();
        Person p1 = new Person("张三",20,"男");
        Person p2 = new Person("李四",30,"男");
        jsonArray.add(p1);
        jsonArray.add(p2);
        System.out.println(jsonArray.toString());
    }
    public void fun4() {
        Person p1 = new Person("张三",20,"男");
        Person p2 = new Person("李四",30,"男");
        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        // 将list转换为JSONArray对象
        JSONArray jsonArray = JSONArray.fromObject(list);
        System.out.println(jsonArray.toString());
    }
}
