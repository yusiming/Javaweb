package yu.responseOeject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Auther: yusiming
 * @Date: 2018/7/24 14:43
 * @Description:
 */
@WebServlet(name = "MyServletA",urlPatterns = {"/MyServletA"})
public class MyServletA extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.print("Hello");
    }
}
