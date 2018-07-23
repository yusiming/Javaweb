package yu.servletTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yu on 2018/7/22
 */
@WebServlet(name = "Bservlet")
public class Bservlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("hello...");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost()...");
    }
}
