/**
 * Created by yu on 2018/7/21
 */
public class Ex3 {
    public static void main(String[] args) {
        int[] numbers = {13,89,45,-78,8};
        for (int i:numbers) {
            assert i>0:"数字不能小于0";
            System.out.println(i);
        }
    }
}
