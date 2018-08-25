package yu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: yusiming
 * @Date: 2018/8/25 11:00
 * @Description:
 */
@WebServlet(name = "JsonServlet",urlPatterns = {"/JsonServlet"})
public class JsonServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        response.setContentType("text/html;charset=utf-8");
        // 向客户端发送json字符串
        String str = "{\"name\":\"虞四明\",\"age\":18,\"sex\":\"male\"}";
        response.getWriter().print(str);
    }
}
