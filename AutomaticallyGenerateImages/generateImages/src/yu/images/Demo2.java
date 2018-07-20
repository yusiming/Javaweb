package yu.images;

import cn.itcast.vcode.utils.VerifyCode;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;

/**
 * Created by yu on 2018/7/20
 */
public class Demo2 {
    public static void main(String[] args) throws Exception {
        VerifyCode code = new VerifyCode();
        BufferedImage image = code.getImage();
        code.output(image,new FileOutputStream("D:/Images/b.jpg"));
    }
}
