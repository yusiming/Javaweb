package yu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Map;

/**
 * @Auther: yusiming
 * @Date: 2018/8/19 15:48
 * @Description: 分ip统计访问次数
 * 从application中获取map
 * 从request中，获取ip地址
 * 进行统计工作，结果保存到map中
 */
@WebFilter(filterName = "AFilter", urlPatterns = {"/*"})
public class AFilter implements Filter {
    private FilterConfig config;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException,
            IOException {
        // 得到servletContext，
        ServletContext servletContext = config.getServletContext();
        Map<String, Integer> map = (Map<String, Integer>) servletContext.getAttribute("map");
        // 从request中获取ip地址
        String remoteAddr = req.getRemoteAddr();
        // 判断之前是否访问过本站
        if (map.containsKey(remoteAddr)) {
            int n = map.get(remoteAddr);
            map.put(remoteAddr, n + 1);
        } else {
            map.put(remoteAddr, 1);
        }
        // 肯定放行
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

}
