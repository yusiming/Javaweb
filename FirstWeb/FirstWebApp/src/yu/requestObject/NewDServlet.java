package yu.requestObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: yusiming
 * @Date: 2018/7/24 15:21
 * @Description:
 */
@WebServlet(name = "NewDServlet",urlPatterns = {"/NewDServlet"})
public class NewDServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取协议
        System.out.println(request.getScheme() + "/n");
        //获取服务器名
        System.out.println(request.getServerName());
        //获取服务器端口
        System.out.println(request.getServerPort());
        //获取项目名
        System.out.println(request.getContextPath());
        //获取Servlet路径
        System.out.println(request.getServletPath());
        //获取参数部分，？后后面的部分
        System.out.println(request.getQueryString());
        //获取项目URI相当于向项目名加Servlet路径
        System.out.println(request.getRequestURI());
        //获取请求URL不包含参数部分的整个请求路径
        System.out.println(request.getRequestURL());
    }
}
