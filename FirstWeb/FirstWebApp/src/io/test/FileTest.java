package io.test;

import java.io.File;
import java.io.IOException;

/**
 * 有关File类的练习
 * Created by yu on 2018/7/23
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        File file = new File("yu.txt");
        //exists方法判断文件谁否存在
        //System.out.println(file.exists());
        //createNewFile方法在当前目录下创建一个新的文件
        //file.createNewFile();
        //System.out.println(file.exists());
        //判断文件是否可以被写入
        System.out.println(file.canWrite());
        //判断文件是否可读
        System.out.println(file.canRead());
        //length方法获取文件的长度，单位是字节
        System.out.println(file.length());
        //getAbsolutePath方法获取文件的绝对路径
        System.out.println(file.getAbsolutePath());
        //getParent方法获取父目录
        System.out.println(file.getParent());
        //判断文件是否是一个普通文件而不是目录
        System.out.println(file.isFile());
        //判断文件是否是一个目录而不是文件
        System.out.println(file.isDirectory());
        //判断文件是否是一个隐藏文件
        System.out.println(file.isHidden());
        //获取文件的最后修改时间,时间是格林乔治时间至文件最后修改时间的毫秒数
        System.out.println(file.lastModified());
    }
}
