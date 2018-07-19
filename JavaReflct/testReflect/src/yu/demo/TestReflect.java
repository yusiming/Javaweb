package yu.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * Created by yu on 2018/7/19
 */
public class TestReflect {
    public static void main(String[] args) throws Exception {
        h();
    }

    //使用反射操作无参数的构造方法
    public static void f() throws Exception {
        //Class c1 = new Person().getClass();
        //Class c1= Person.class;
        Class c1 = Class.forName("yu.demo.Person");
        Person p1 = (Person) c1.getDeclaredConstructor().newInstance();
        p1.setName("虞");
        System.out.println(p1.getName());
    }

    //使用反射操作有参数的构造方法
    public static void g() throws Exception {
        Class c2 = Class.forName("yu.demo.Person");
        Constructor constructor = c2.getConstructor(String.class, String.class);
        Person person = (Person) constructor.newInstance("虞", "20");
        System.out.println(person.getName() + person.getAge());
    }

    //使用反射操作属性
    public static void h() throws Exception {
        Class c3 = Class.forName("yu.demo.Person");
        Person person = (Person) c3.getDeclaredConstructor().newInstance();
        Field field = c3.getField("name");
        field.set(person,"虞四明");
        System.out.println(field.get(person));
    }
}