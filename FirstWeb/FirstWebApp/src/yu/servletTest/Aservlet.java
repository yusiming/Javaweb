package yu.servletTest;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by yu on 2018/7/22
 */
public class Aservlet extends MyGenericServlet{
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init()...");
    }
    public void init() {

    }
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public ServletConfig getServletConfig() {
        return super.getServletConfig();
    }
}
