package yu.boxingAndUnboxing;

/**
 * @Auther: yusiming
 * @Date: 2018/8/12 14:18
 * @Description:
 */
public class Demo1 {
    public static void main(String[] args) {
        // 自动装箱，把基本类型直接赋值给对应的引用类型
        Integer integer = 10;
        // integer = Integer.valueOf(10);
        // 自动拆箱
        int n = fun1(10);
        // n = fun1(10).intValue();
        System.out.println(integer);
        System.out.println(n);
    }
    private static Integer fun1(int a) {
        return a;
    }
}
