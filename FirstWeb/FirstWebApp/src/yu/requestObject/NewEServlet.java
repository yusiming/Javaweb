package yu.requestObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * @Auther: yusiming
 * @Date: 2018/7/24 15:35
 * @Description:
 */
@WebServlet(name = "NewEServlet", urlPatterns = {"/NewEServlet"})
public class NewEServlet extends HttpServlet {

    /**
     * @Description: 获取请求参数
     * @auther: yusiming
     * @date: 16:02 2018/7/24
     * @param: [request, response]
     * @return: void
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取指定参数的值
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        //多值头
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println("hobby: " + Arrays.toString(hobbies));
        //获取所有请求参数名称
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            System.out.println(parameterNames.nextElement());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String xxx = request.getParameter("xxx");
        String yyy = request.getParameter("yyy");
        System.out.println("xxx: " + xxx);
        System.out.println("yyy: " + yyy);
    }
}
