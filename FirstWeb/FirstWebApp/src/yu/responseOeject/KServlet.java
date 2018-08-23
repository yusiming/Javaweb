package yu.responseOeject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yu on 2018/7/23
 * 发送定时刷新头给客户端
 */
@WebServlet(name = "KServlet", urlPatterns = {"/KServlet"})
public class KServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Refresh", "5;URL=/FirstWebApp/LServlet");
        PrintWriter writer = response.getWriter();
        writer.print("欢迎登陆");
    }
}
