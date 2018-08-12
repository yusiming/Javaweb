package yu.string;

/**
 * @Auther: yusiming
 * @Date: 2018/7/30 09:55
 * @Description: 测试String类的一些常用方法
 */
public class Test1 {
    public static void main(String[] args) {
        String s1 = new String("yusiming");
        System.out.println(s1);
        // length 方法返回String对象中的字符序列的长度
        System.out.println(s1.length());
        System.out.println("Yusiming".equalsIgnoreCase(s1));
        System.out.println(s1.startsWith("yu"));
        System.out.println(s1.endsWith("ming"));
        System.out.println("abc".compareToIgnoreCase("ABE"));
        System.out.println(s1.contains("yu"));
        System.out.println(s1.indexOf("i", 4));
        String substring = s1.substring(2, 4);
        System.out.println(substring);
        System.out.println(" yusiming ".trim().length());
    }
}
