package yu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yu on 2018/7/23
 * 访问量统计案例
 */
@WebServlet(name = "GServlet",urlPatterns = {"/GServlet"})
public class GServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        Integer s = (Integer) servletContext.getAttribute("counter");
        //如果是第一次访问，则在ServletContext创建一个变量，不是第一次则将访问量加一
        if (s == null) {
            servletContext.setAttribute("counter",1);
        }else {
            servletContext.setAttribute("counter",s+1);
        }
        //将访问量输出到客户端
        PrintWriter writer = response.getWriter();
        writer.print("<h1>" + s + "</h1>");
    }
}
