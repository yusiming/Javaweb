package io.test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Auther: yusiming
 * @Date: 2018/7/28 09:27
 * @Description:
 */
public class Ex4 {
    public static void main(String[] args) throws IOException {
        char[] arr1 = new char[100];
        File file = new File("a.txt");
        FileReader reader = new FileReader(file);
        //该方法返回实际读取的字符数
        int n = reader.read(arr1);
        for (char c:arr1) {
            System.out.println(c);
        }
        System.out.println(n);
    }
}
