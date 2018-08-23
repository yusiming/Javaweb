package yu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: yusiming
 * @Date: 2018/8/23 12:34
 * @Description:
 */
@WebServlet(name = "VerifyUsernameServlet", urlPatterns = {"/VerifyUsernameServlet"})
public class VerifyUsernameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String username = request.getParameter("username");
        if (username.equalsIgnoreCase("yu")) {
            response.getWriter().print("1");
        } else {
            response.getWriter().print("0");
        }
    }
}
