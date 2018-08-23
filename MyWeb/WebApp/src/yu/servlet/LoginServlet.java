package yu.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @Auther: yusiming
 * @Date: 2018/7/27 13:21
 * @Description:
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    /**
     * @Description: 处理login.jsp页面发送过来的数据, 做出响应
     * @auther: yusiming
     * @date: 15:07 2018/7/27
     * @param: [request, response]
     * @return: void
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //在得到参数之前,必须要设置字符编码
        request.setCharacterEncoding("utf-8");
        //得到参数值
        String name = (String) request.getParameter("name");
        String password = (String) request.getParameter("password");
        //判断验证码是否正确
        String userVerifyCode = request.getParameter("userVerifyCode");
        HttpSession session = request.getSession();
        String rightVerifyCode = (String) session.getAttribute("rightVerifyCode");
        if (!rightVerifyCode.equalsIgnoreCase(userVerifyCode)) {
            request.setAttribute("message", "验证码错误");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
            requestDispatcher.forward(request, response);
        }
        //判断用户名是否已虞开头如果是则让其登陆
        if (name.startsWith("陈")) {
            //在往Cookie中设置中文时，先进行URL编码
            String userName = URLEncoder.encode(name, "utf-8");
            System.out.println(userName);
            System.out.println(name);
            //将用户名发送到客户端，以便下一次请求login.jsp时可以记住用户名
            Cookie cookie = new Cookie("userName", userName);
            cookie.setMaxAge(60 * 60);
            response.addCookie(cookie);
            //登陆成功时，往session中保存信息，以便成功页面判断是否已经登陆
            session.setAttribute("name", name);
            //重定向到成功页面
            response.sendRedirect("/WebApp/session2/successPage1.jsp");
        } else {
            //登陆失败，保存信息到request域中，
            request.setAttribute("message", "登陆失败，");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
