/**
 * Created by yu on 2018/7/21
 */
public class Ex2 {
    public static void main(String[] args) {
        Yu yu = new Yu();
        try {
            yu.Fun(1,18);
        }
        catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
}
class Yu {
    public int Fun(int a, int b) throws MyException {
        if (b>10) {
            throw new MyException("数字太大");
        }
        else return a/b;
    }
}
