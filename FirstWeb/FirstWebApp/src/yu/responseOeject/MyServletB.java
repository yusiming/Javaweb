package yu.responseOeject;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: yusiming
 * @Date: 2018/7/24 14:45
 * @Description:
 */
@WebServlet(name = "MyServletB",urlPatterns = {"/MyServletB"})
public class MyServletB extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.print("D:\\JavaWeb\\FirstWeb\\FirstWebApp\\src\\images\\1888676_p0.jpg");
    }
}
