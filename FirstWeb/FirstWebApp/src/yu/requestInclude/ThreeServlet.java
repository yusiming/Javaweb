package yu.requestInclude;

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
 * @Date: 2018/7/24 16:56
 * @Description:
 */
@WebServlet(name = "ThreeServlet",urlPatterns = {"/ThreeServlet"})
public class ThreeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ThreeServlet...");
        //设置响应头
        response.setHeader("aaa","AAA");
        //设置响应体,请求包含可以设置响应体
        PrintWriter writer = response.getWriter();
        writer.print("Hello1...");
        //在域对象中设置属性
        request.setAttribute("name","yu");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/FourServlet");
        requestDispatcher.include(request,response);
    }
}
