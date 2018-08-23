package yu.requestInclude;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: yusiming
 * @Date: 2018/7/24 16:57
 * @Description:
 */
@WebServlet(name = "FourServlet",urlPatterns = {"/FourServlet"})
public class FourServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FourServlet...");
        //打印属性
        System.out.println(request.getAttribute("name"));
        //设置响应头,好像没用
        response.setHeader("bbb","BBB");
        //设置响应体
        response.getWriter().print("Hello2...");

    }
}
