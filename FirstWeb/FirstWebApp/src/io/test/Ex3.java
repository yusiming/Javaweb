package io.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Auther: yusiming
 * @Date: 2018/7/28 09:17
 * @Description:
 */
public class Ex3 {
    public static void main(String[] args) throws IOException {
        File file = new File("a.txt");
        file.createNewFile();
        char[] arr1 = {'虞','四','明'};
        //如果传入方法参数true，则不覆盖原有的数据
        FileWriter writer = new FileWriter(file,true);
        writer.write(arr1);
        writer.close();
    }
}
