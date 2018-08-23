package yu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Auther: yusiming
 * @Date: 2018/8/16 16:10
 * @Description:
 */
@WebFilter(filterName = "Filter0_yu",value = {"/CServlet"})
public class Filter0_yu implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("1");
        chain.doFilter(req, resp);
        System.out.println("2");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
