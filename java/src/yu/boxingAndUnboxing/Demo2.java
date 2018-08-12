package yu.boxingAndUnboxing;

/**
 * @Auther: yusiming
 * @Date: 2018/8/12 14:28
 * @Description:
 */
public class Demo2 {
    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;
        // true
        System.out.println(a == b);
        Integer c = 200;
        Integer d = 200;
        // false,Integer内部缓存了 -128 到 127 之间的256个，integer对象，
        System.out.println(c == d);
    }
}
