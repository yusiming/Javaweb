package yu.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by yu on 2018/7/19
 */
public class TestReflect {
    public static void main(String[] args) throws Exception {
        a();
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

    //使用反射操作私有属性
    public static void h() throws Exception {
        Class c3 = Class.forName("yu.demo.Person");
        Person person = (Person) c3.getDeclaredConstructor().newInstance();
        Field field = c3.getDeclaredField("name");
        //需要使用setAccessible方法使其能够操作私有属性
        field.setAccessible(true);
        field.set(person, "虞四明");
        System.out.println(field.get(person));
    }
    public static void a() throws Exception {
        Class c4 = Class.forName("yu.demo.Person");
        Person person = (Person) c4.getDeclaredConstructor().newInstance();
        Method method = c4.getDeclaredMethod("setAge",String.class);
        //如果是私有方法需要使用setAccessible方法来使其能够操作私有方法
        method.setAccessible(true);
        //如果是static方法，invoke方法中的第一个参数要传null
        method.invoke(person,"30");
        System.out.println(person.getAge());
    }
}