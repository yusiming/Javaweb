package yu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Auther: yusiming
 * @Date: 2018/8/16 16:09
 * @Description:
 */
@WebFilter(filterName = "Filter2_yu",urlPatterns = {"/CServlet"})
public class Filter2_yu implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("3");
        chain.doFilter(req, resp);
        System.out.println("4");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
