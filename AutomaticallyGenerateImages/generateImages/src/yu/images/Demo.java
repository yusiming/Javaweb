package yu.images;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;

/**
 * Created by yu on 2018/7/20
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        //使用BufferedImage类得到图片缓冲区
        BufferedImage bufferedImage = new BufferedImage(70,35,BufferedImage.TYPE_INT_RGB);
        //得到绘制环境
        Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
        //设置颜色
        graphics.setColor(Color.WHITE);
        //填充一个矩形,整张图片,其实就是设置了背景色
        graphics.fillRect(0,0,70,35);
        graphics.setColor(Color.RED);
        graphics.drawRect(0, 0,69,34);
        //设置字体
        graphics.setFont(new Font("宋体",Font.BOLD,20));
        //设置颜色
        graphics.setColor(Color.BLACK);
        //像图片上添加字符串
        graphics.drawString("虞四明",0,30);
        //保存图片
        boolean jpeg = ImageIO.write(bufferedImage, "JPEG", new FileOutputStream("D:/Images/a.jpg"));
    }
}