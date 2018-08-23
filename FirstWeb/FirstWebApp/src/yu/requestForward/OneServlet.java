package yu.requestForward;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Auther: yusiming
 * @Date: 2018/7/24 16:35
 * @Description:
 */
@WebServlet(name = "OneServlet",urlPatterns = {"/OneServlet"})
public class OneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    /**
     *
     * @Description:
     * 请求转发的演示
     * @auther: yusiming
     * @date: 16:44 2018/7/24
     * @param: [request, response]
     * @return: void
     *
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("OneServlet...");
        //设置响应头
        response.setHeader("aaa","AAA");
        //设置响应体，无法显示在客户端
        PrintWriter writer = response.getWriter();
        //无法显示，不应该设置响应体
        writer.print("Hello1");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/TwoServlet");
        requestDispatcher.forward(request,response);
    }
}
