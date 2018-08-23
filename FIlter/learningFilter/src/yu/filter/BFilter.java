package yu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Auther: yusiming
 * @Date: 2018/8/16 15:51
 * @Description:
 */
@WebFilter(filterName = "BFilter", urlPatterns = {"/BServlet"},dispatcherTypes = DispatcherType.REQUEST)
public class BFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException,
            IOException {
        System.out.println("BFilter开始");
        chain.doFilter(req, resp);
        System.out.println("BFilter结束");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
