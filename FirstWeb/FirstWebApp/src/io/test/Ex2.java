package io.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by yu on 2018/7/23
 */
public class Ex2 {
    public static void main(String[] args) {
        byte[] a = "新年快乐".getBytes();
        byte[] b = "happy new year".getBytes();
        try {
            File file = new File("ex2.txt");
            FileOutputStream stream = new FileOutputStream(file, false);
            stream.write(a);
            stream.close();
            stream = new FileOutputStream(file, true);
            stream.write(b);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
