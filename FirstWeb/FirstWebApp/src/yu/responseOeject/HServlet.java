package yu.responseOeject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 给客户端发送404状态码
 * Created by yu on 2018/7/23
 */
@WebServlet(name = "HServlet", urlPatterns = {"/HServlet"})
public class HServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(404, "您请求的资源不存在");
    }
}
