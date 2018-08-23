package yu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: yusiming
 * @Date: 2018/8/16 15:31
 * @Description:
 */
@WebServlet(name = "AServlet",urlPatterns = {"/AServlet"})
public class AServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        System.out.println("执行AServlet");
        request.getRequestDispatcher("/BServlet").forward(request, response);
    }
}
