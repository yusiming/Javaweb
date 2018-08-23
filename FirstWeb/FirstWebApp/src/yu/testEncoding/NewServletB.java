package yu.testEncoding;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: yusiming
 * @Date: 2018/7/25 10:30
 * @Description:
 */
@WebServlet(name = "NewServletB",urlPatterns = {"/NewServletB"})
public class NewServletB extends HttpServlet {
    /**
     *
     * @Description:
     * post方式在得到请求参数之前，需要先设置编码方式为utf-8
     * @auther: yusiming
     * @date: 10:42 2018/7/25
     * @param: [request, response]
     * @return: void
     *
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("username");
        System.out.println(name);
    }
    /**
     *
     * @Description:
     * get方式，不需要设置编码方式，在之前的tomcat版本需要设置
     * @auther: yusiming
     * @date: 10:44 2018/7/25
     * @param: [request, response]
     * @return: void
     *
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        System.out.println(name);
        //以下方法在tomcat8版本失效，tomcat8版本get方式获取请求参数默认编码utf-8
        /*String name = request.getParameter("name");
        byte[] bytes = name.getBytes("iso-8859-1");
        name = new String(bytes,"utf-8");
        System.out.println(name);*/
    }
}
