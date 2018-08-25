package yu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: yusiming
 * @Date: 2018/8/24 09:49
 * @Description:
 */
@WebServlet(name = "Ajax2Servlet", urlPatterns = {"/Ajax2Servlet"})
public class Ajax2Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String xml = "<students>" +
                "<student number='311509030129'>" +
                "<name>虞四明</name>" +
                "<age>20</age>" +
                "<sex>男</sex>" +
                "</student>" +
                "</students>";
        response.setContentType("text/xml;charset=UTF-8");
        response.getWriter().print(xml);
    }
}
