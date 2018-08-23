package yu.baseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: yusiming
 * @Date: 2018/8/10 17:12
 * @Description:
 */
@WebServlet(name = "NewServletA", urlPatterns = {"/NewServletA"})
public class NewServletA extends BaseServlet {
    public String fun1(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return "f:/index.jsp";
    }

    public String fun2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return "r:/index.jsp";
    }

    public String fun3(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return null;
    }

    public String fun4(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return "/index.jsp";
    }

    public String fun5(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return "d:/index.jsp";
    }
}
