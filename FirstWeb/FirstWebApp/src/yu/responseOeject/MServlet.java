package yu.responseOeject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 禁用缓存
 * Created by yu on 2018/7/23
 */
@WebServlet(name = "MServlet",urlPatterns = {"/MServlet"})
public class MServlet extends HttpServlet {
    //Cache-Control、pragma、expires
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("pragma","no-cache");
        response.setDateHeader("expires",-1);
    }
}
