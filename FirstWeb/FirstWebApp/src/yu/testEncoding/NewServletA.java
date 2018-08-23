package yu.testEncoding;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Auther: yusiming
 * @Date: 2018/7/25 09:55
 * @Description:
 */
@WebServlet(name = "NewServletA",urlPatterns = {"/NewServletA"})
public class NewServletA extends HttpServlet {
    /**
     *
     * @Description: 
     * 服务器会默认使用iso编码，一般浏览器使用gbk编码，我们需要在发送响应之前设置字符编码为utf-8
     * 然后再告诉浏览器我们使用的是utf-8，就可以了
     * @auther: yusiming
     * @date: 10:39 2018/7/25 
     * @param: [request, response]
     * @return: void
     *
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-Type","text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        //可以使用setContentType方法来设置编码，相当于上面俩个方法的作用
        //response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print("你好啊");
    }
}
