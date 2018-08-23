package yu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Auther: yusiming
 * @Date: 2018/8/19 17:18
 * @Description: 针对会员用户
 */
@WebFilter(filterName = "AFilter")
public class AFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException,
            IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") != null) {
            chain.doFilter(req, resp);
        } else if (session.getAttribute("user") != null) {
            chain.doFilter(req, resp);
        } else {
            request.setAttribute("msg", "你不是会员或者管理员");
            request.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
