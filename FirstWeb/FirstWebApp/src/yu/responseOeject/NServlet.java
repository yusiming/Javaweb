package yu.responseOeject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: yusiming
 * @Date: 2018/7/24 14:29
 * @Description:
 */
@WebServlet(name = "NServlet",urlPatterns = {"/NServlet"})
public class NServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("http://www.bilibili.com");
    }
}
