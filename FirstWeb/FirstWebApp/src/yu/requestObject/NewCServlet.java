package yu.requestObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: yusiming
 * @Date: 2018/7/24 15:17
 * @Description:
 */
@WebServlet(name = "NewCServlet",urlPatterns = {"/NewCServlet"})
public class NewCServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    /**
     *
     * @Description:
     * 获取客户端的Host请求头的值
     * @auther: yusiming
     * @date: 15:20 2018/7/24
     * @param: [request, response]
     * @return: void
     *
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String host = request.getHeader("Host");
        System.out.println(host);
    }
}
