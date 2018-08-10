package jdbc.thread;

/**
 * @Auther: yusiming
 * @Date: 2018/8/9 20:46
 * @Description:
 */
public class Demo1 {
    public void fun1() {
        ThreadLocal<String> threadLocal = new ThreadLocal<String>();
        //存数据
        threadLocal.set("hello");
        threadLocal.set("你好");
        //取数据
        String s = threadLocal.get();
        //移除数据
        threadLocal.remove();
        System.out.println(s);
    }
}
