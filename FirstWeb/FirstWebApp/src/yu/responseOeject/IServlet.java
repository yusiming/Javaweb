package yu.responseOeject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 演示重定向
 * Created by yu on 2018/7/23
 */
@WebServlet(name = "IServlet",urlPatterns = {"/IServlet"})
public class IServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Location","/FirstWebApp/JServlet");
        response.setStatus(302);
        System.out.println("IServlet");
    }
}
