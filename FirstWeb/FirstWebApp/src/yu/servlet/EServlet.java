package yu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by yu on 2018/7/23
 */
@WebServlet(name = "EServlet",urlPatterns = {"/EServlet"})
public class EServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        //getInitParameter方法的使用
        String initParameter1 = servletContext.getInitParameter("context - name1");
        String initParameter2 = servletContext.getInitParameter("context - name2");
        System.out.println(initParameter1);
        System.out.println(initParameter2);
        //
        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            System.out.println(initParameterNames.nextElement());
        }
    }
}
