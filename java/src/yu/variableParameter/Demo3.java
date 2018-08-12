package yu.variableParameter;

/**
 * @Auther: yusiming
 * @Date: 2018/8/12 14:52
 * @Description:
 */
public class Demo3 {
    public static void main(String[] args) {
        double[] arr = {1,2};
        fun1(1,2);
        fun1(arr);
        // fun(1,2);错误的
        fun2(arr);
    }

    public static void fun1(double... n) {
        double sum = 0;
        for (int i = 0; i < n.length; i++) {
            sum = sum + n[i];
        }
        System.out.println(sum);
    }

    public static void fun2(double[] args) {
        double sum = 0;
        for (int i = 0; i < args.length; i++) {
            sum = sum + args[i];
        }
        System.out.println(sum);
    }
}
