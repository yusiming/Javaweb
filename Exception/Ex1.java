/**
 * Created by yu on 2018/7/21
 */
public class Ex1 {
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        try {
            a= Integer.parseInt("aa122");                   //parseInt方法抛出异常
            b = Integer.parseInt("123");
        }
        catch (NumberFormatException e) {
            System.out.println("发生异常: " + e.getMessage());
        }
        System.out.println("a = " + a + "b = " + b);
        try {
            throw new NumberFormatException("故意抛出异常");
        }
        catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
