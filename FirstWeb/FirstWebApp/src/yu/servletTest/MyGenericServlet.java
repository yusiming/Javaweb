package yu.servletTest;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 模拟GenericServlet的实现
 * Created by yu on 2018/7/22
 */
public abstract class MyGenericServlet implements Servlet, ServletConfig {
    //添加一个私有成员变量，在init()方法中得到实体
    private ServletConfig servletConfig;

    //服务器会给init方法传递一个GenericServlet对象，我们可以将这个对象保存
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
        init();
    }

    //方法重载，此方法会与有参的init方法绑定，在Servlet对象创建时，就执行
    public void init() {
        //可以做一些初始化操作
    }

    @Override
    public abstract void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException;

    @Override
    public void destroy() {
        System.out.println("destroy()...");
    }

    //通过servletConfig成员变量得到ServletConfig对象，从而实现方法
    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public String getServletName() {
        return servletConfig.getServletName();
    }

    @Override
    public ServletContext getServletContext() {
        return servletConfig.getServletContext();
    }

    @Override
    public String getInitParameter(String s) {
        return servletConfig.getInitParameter(s);
    }

    @Override
    public Enumeration<String> getInitParameterNames() {
        return servletConfig.getInitParameterNames();
    }
}
