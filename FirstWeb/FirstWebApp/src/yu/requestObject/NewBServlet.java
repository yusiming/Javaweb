package yu.requestObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Auther: yusiming
 * @Date: 2018/7/24 13:27
 * @Description:
 */
@WebServlet(name = "NewBServlet",urlPatterns = {"/NewBServlet"})
public class NewBServlet extends HttpServlet {
    /**
     * @Description:
     * @auther: yusiming
     * @date: 13:28 2018/7/24
     * @param: [request, response]
     * @return: void
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String referer = request.getHeader("Referer");
        System.out.println(referer);
        if (referer.contains("localhost")) {
            response.setHeader("Location","http://www.baidu.com");
            response.setStatus(302);
        } else {
            PrintWriter writer = response.getWriter();
            writer.print("Hello");
        }
    }
}
