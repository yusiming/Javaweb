package io.test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Auther: yusiming
 * @Date: 2018/7/28 09:36
 * @Description:
 */
public class Ex5 {
    /**
     * @Description: 将a.txt中的字符写入到b.txt中
     * @auther: yusiming
     * @date: 9:38 2018/7/28
     * @param: [args]
     * @return: void
     */
    public static void main(String[] args) throws IOException {
        File file1 = new File("a.txt");
        File file2 = new File("b.txt");
        int n = 0;
        char[] arr1 = new char[100];
        file2.createNewFile();
        FileReader reader = new FileReader(file1);
        FileWriter writer = new FileWriter(file2);
        while ((n = reader.read(arr1)) != -1) {
            System.out.println(arr1[0]);
            writer.write(arr1,0,n);
        }
        writer.flush();
        writer.close();
    }
}
