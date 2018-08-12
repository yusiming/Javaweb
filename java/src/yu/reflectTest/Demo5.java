package yu.reflectTest;

import java.lang.reflect.Constructor;

/**
 * @Auther: yusiming
 * @Date: 2018/8/12 15:46
 * @Description:
 */
public class Demo5 {
    public static void main(String[] args) throws Exception {
        User user = new User();
        // 获取Class对象的三种方法
        Class<User> userClass = User.class;
        Class userClass1 = Class.forName("yu.reflectTest.User");
        Class userClass2 = user.getClass();

        // Class类常用方法,获取类名，包含包名 yu.reflectTest.User
        System.out.println(userClass.getName());
        // 获取类名，不包含包名 User
        System.out.println(userClass.getSimpleName());
        // 获取父类的名字 class java.lang.Object
        System.out.println(userClass.getSuperclass());
        System.out.println(Object.class.getSuperclass());

        // 使用反射创建对象 null
        Constructor<User> userConstructor1 = userClass.getDeclaredConstructor(String.class, String.class);
        userConstructor1.setAccessible(true);
        User u = userConstructor1.newInstance("虞四明","314159");
        System.out.println(u.getUsername());
        System.out.println(u.getPassword());

        // 获取构造器对象 Constructor is not public,此方法只能获公有构造方法
        //userClass.getConstructor(String.class,String.class);
        Constructor<User> constructor = userClass.getConstructor();
        // 获取所有公有构造方法
        Constructor<?>[] constructors = userClass.getConstructors();
        // 根据参数获取指定的构造方法，包括私有构造方法
        Constructor<User> userConstructor = userClass.getDeclaredConstructor(String.class, String.class);
        // 获取所有构造方法，包括私有构造方法
        Constructor<?>[] declaredConstructors = userClass.getDeclaredConstructors();

        // Constructor类常用方法,获取构造器名字
        System.out.println(userConstructor.getName());
        // 获取构造器类型
        System.out.println(userConstructor.getDeclaringClass());
        // 获取构造器的参数类型
        System.out.println(userConstructor.getParameterTypes());
        // 获取所声明的参数类型
        System.out.println(userConstructor.getExceptionTypes());

    }
}