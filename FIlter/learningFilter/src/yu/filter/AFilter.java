package yu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Auther: yusiming
 * @Date: 2018/8/16 15:34
 * @Description:
 */
@WebFilter(filterName = "AFilter",urlPatterns = {"/index.jsp"})
public class AFilter implements Filter {
    /**
     * @Description: 创建AFilter之后立即执行该方法
     * @auther: yusiming
     * @date: 15:35 2018/8/16
     * @param: [config]
     * @return: void
     */
    public void init(FilterConfig config) throws ServletException {
        System.out.println("AFilter被创建了");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException,
            IOException {
        System.out.println("AFilter开始");
        // 该方法会执行目标资源的某些方法，或者是执行下一个过滤器的doFilter方法，
        chain.doFilter(req, resp);
        System.out.println("AFilter结束");
    }

    public void destroy() {
        System.out.println("AFilter被销毁了");
    }

}
