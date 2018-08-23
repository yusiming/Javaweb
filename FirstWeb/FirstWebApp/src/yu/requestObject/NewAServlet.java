package yu.requestObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: yusiming
 * @Date: 2018/7/24 12:31
 * @Description:
 */
@WebServlet(name = "NewAServlet",urlPatterns = {"/NewAServlet"})
public class NewAServlet extends HttpServlet {
    /**
     * @Description: 获取客户端的IP地址、请求方式、请求头
     * @auther: yusiming
     * @date: 12:31 2018/7/24
     * @param: [request, response]
     * @return: void
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到IP地址
        String remoteAddr = request.getRemoteAddr();
        //得到请求方式
        String method = request.getMethod();
        //得到请求头
        String userAgenthHeader = request.getHeader("User-Agent");
        /* 判断客户端使用的浏览器
        * Edge：Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.140 Safari/537.36 Edge/17.17134
        * 谷歌：Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.79 Safari/537.36
        * IE:Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko
        */
        if (userAgenthHeader.toLowerCase().contains("chrome")) {
            System.out.println("你的IP地址是：  " + remoteAddr + " 你使用的是： " + "谷歌浏览器");
        } else if (userAgenthHeader.toLowerCase().contains("msie")) {
            System.out.println("你的IP地址是：  " + remoteAddr + " 你使用的是： " + "IE浏览器");
        } else if (userAgenthHeader.toLowerCase().contains("firefox")) {
            System.out.println("你的IP地址是：  " + remoteAddr + " 你使用的是： " + "火狐浏览器");
        }
    }
}
