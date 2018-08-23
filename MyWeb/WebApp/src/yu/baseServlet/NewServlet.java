package yu.baseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: yusiming
 * @Date: 2018/8/10 16:22
 * @Description: 在service方法内部根据传递过来的参数，调用不同的方法
 */
@WebServlet(name = "NewServlet", urlPatterns = {"/NewServlet"})
public class NewServlet extends BaseServlet {
    public void addUser(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        System.out.println("addUser");

    }

    public void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("updateUser");
    }

    public void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("deleteUser");
    }
}
