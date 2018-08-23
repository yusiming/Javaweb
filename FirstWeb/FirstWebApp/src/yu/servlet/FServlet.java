package yu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yu on 2018/7/23
 */
@WebServlet(name = "FServlet",urlPatterns = {"/FServlet"})
public class FServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取文件的真实路径
        ServletContext servletContext = this.getServletContext();
        String realPath1 = servletContext.getRealPath("/index.jsp");
        String realPath2 = servletContext.getRealPath("/WEB-INF/web.xml");
        System.out.println(realPath1);
        System.out.println(realPath2);
        //D:\JavaWeb\FirstWeb\out\artifacts\FirstWebApp_war_exploded\index.jsp
        //D:\JavaWeb\FirstWeb\out\artifacts\FirstWebApp_war_exploded\WEB-INF\web.xml
    }
}
