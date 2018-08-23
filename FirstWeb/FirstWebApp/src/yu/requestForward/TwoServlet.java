package yu.requestForward;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: yusiming
 * @Date: 2018/7/24 16:42
 * @Description:
 */
@WebServlet(name = "TwoServlet",urlPatterns = {"/TwoServlet"})
public class TwoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    /**
     *
     * @Description:
     * 设置响应体
     * @auther: yusiming
     * @date: 16:47 2018/7/24
     * @param: [request, response]
     * @return: void
     *
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("TwoServlet...");
        response.getWriter().print("Hello2");
    }
}
