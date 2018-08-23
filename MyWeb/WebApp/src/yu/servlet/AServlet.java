package yu.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: yusiming
 * @Date: 2018/7/25 14:31
 * @Description:
 */
@WebServlet(name = "AServlet",urlPatterns = {"/AServlet"})
public class AServlet extends HttpServlet {
    /**
     *
     * @Description:
     * 得到form.jsp页面传递过来的数据，并相加，保存到request域中
     * 再转发给result.jsp页面
     * @auther: yusiming
     * @date: 14:14 2018/7/26
     * @param: [request, response]
     * @return: void
     *
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到请求数据
        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        //求值
        int result = Integer.parseInt(number1) + Integer.parseInt(number2);
        //把运算结果把保存到request域中
        request.setAttribute("result",result);
        //转发到result.jsp中
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/add/result.jsp");
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
