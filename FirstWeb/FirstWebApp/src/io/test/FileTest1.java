package io.test;

import java.io.File;

/**
 * 文件夹的创建
 * 输入文件夹下的文件
 * Created by yu on 2018/7/23
 */
public class FileTest1 {
    public static void main(String[] args) {
        //创建名为yu的文件夹
       File file = new File("yu");
        //System.out.println(file.mkdir());
        //以字符串数组的形式返回文件夹下的全部文件的文件名
        String[] list = file.list();
        for (String s:list) {
            System.out.println(s);
        }
        //以File类对象数组的形式返回文件夹下的全部文件的文件名
        File[] files = file.listFiles();
        for (File file1:files) {
            System.out.println(file1.getName());
        }
        //以字符串数组的形式返回文件夹下的指定文件的文件名
        FileAccept accept = new FileAccept();
        accept.setExtendName("java");
        String[] list1 = file.list(accept);
        for (String s:list1) {
            System.out.println(s);
        }
        //以File对象数组的形式返回文件夹下指定文件的文件名
        accept.setExtendName("txt");
        File[] files1 = file.listFiles(accept);
        for (File file1:files1) {
            System.out.println(file1.getName());
        }
    }
}
