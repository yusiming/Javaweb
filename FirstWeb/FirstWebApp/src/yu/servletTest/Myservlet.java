package yu.servletTest;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 查看Servlet接口中的方法
 * Created by yu on 2018/7/21
 */
public class Myservlet implements Servlet {
    /*  init方法在Servlet对象创建之后立即执行，完成对Servlet的初始化操作，只执行一次
    /*  当Servlet第一次被请求时，或服务器启动时，服务器会创建Servlet实例。
     *  服务器默认是在servlet第一次被请求时创建Servlet实例，如果希望服务器启动时就创建Servlet实现需要在web.xml中配置
     *  服务器只为一个类型的Servlet创建一个实例对象，所以Servlet是单例的；
     * */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init()...");
        //得到指定名称的初始化参数的值
        System.out.println(servletConfig.getInitParameter("p1"));
        //得到所有的初始化参数的名称
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            System.out.println(initParameterNames.nextElement());
        }
    }

    //service方法，每次请求Servlet时调用这个方法，会被调用多次
    //每次处理请求时调用这个方法
    /* 当Servlet被请求时，服务器会调用Servlet的service(ServletRequest,ServletResponse)方法
     * service(ServletRequest,ServletResponse)方法每处理一次请求，就会被调用一次，所以它可能会被调用N次
     * 因为Servlet是单例的，所以可能在同一时刻一个Servlet对象会被多个请求同时访问，所以这可能出现线程案例问题
     * Servlet不是线程案例的，这有助与提高效率，但不能让Servlet具有状态，以免多个线程争抢数据
     *
     * */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service()...");
    }

    /*Servlet对象被销毁之前，会调用这个方法
     * 服务器通常不会销毁Servlet，通常只有在服务器关闭时才会销毁Servlet
     * 服务器会在销毁Servlet之前调用Servlet的destory()方法
     * 可以在destory()方法中给出释放Servlet占有的资源，但通常Servlet是没什么可要释放的，所以该方法一般都是空的
     * */
    @Override
    public void destroy() {
        System.out.println("destroy()...");
    }

    //get any startup information,
    //获取Servlet的配置信息
    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig()...");
        return null;
    }

    //return basic information about itself, such as author, version, and copyright.
    //获取Servlet的信息
    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo()...");
        return null;
    }
}
