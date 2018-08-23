package yu.servlet;

import yu.commons.VerifyCode;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Auther: yusiming
 * @Date: 2018/7/28 15:53
 * @Description:
 */
@WebServlet(name = "VerifyCodeServlet",urlPatterns = {"/VerifyCodeServlet"})
public class VerifyCodeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到验证码图片和文字
        VerifyCode verifyCode = new VerifyCode();
        BufferedImage image = verifyCode.getImage();
        String text = verifyCode.getText();
        //将正确验证码保存到session中
        HttpSession session = request.getSession();
        session.setAttribute("rightVerifyCode",text);
        //将图片输出到客户端
        ServletOutputStream outputStream = response.getOutputStream();
        VerifyCode.output(image,outputStream);
    }
}
