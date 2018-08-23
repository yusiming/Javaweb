package io.test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by yu on 2018/7/23
 */
public class Ex1 {
    public static void main(String[] args) {
        int n = 0;
        byte[] a = new byte[100];
        try {
            FileInputStream stream = new FileInputStream("yu.a");
            while ((n=stream.read(a,0,100)) != -1) {
                String s = new String(a,0,n);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
