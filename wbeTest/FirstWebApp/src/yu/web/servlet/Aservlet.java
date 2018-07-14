package yu.web.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by yu on 2018/7/4
 * <p>
 * Servlet中的大多数方法不由我们来调用，而是由tomcat来调用
 * 一个Servlet类只有一个对象
 * Servlet对象也不由我们来创建，由tomcat来创建，
 * 服务器会帮我们来创建对象，调用方法
 */
public class Aservlet implements Servlet {
    /**/    /*
     * 生命周期方法
     * 在Servlet对象创建之后马上执行，只执行一次
     * Servlet对象在第一次被访问时创建
     * 由tomcat来调用这个方法
     * */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init()");
        //获取初始化参数的值
        String n1 = servletConfig.getInitParameter("n1");
        String n2 = servletConfig.getInitParameter("n2");
        System.out.println(n1);
        System.out.println(n2);
        //获取所有初始化参数的值
        Enumeration initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            System.out.println(initParameterNames.nextElement());
        }
    }

    /*
     * 获取Servlet配置信息
     * */
    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig()");
        return null;
    }

    /*
     *生命周期方法
     * 会被调用多次
     * 每次处理请求都会调用这个方法
     * */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service()");
    }

    /*
     * 获取Servlrt的信息
     * */
    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo()");
        return null;
    }

    /*
     * 生命周期方法
     * 在Servlet被销毁之前被调用，并不是用来销毁Servlert，只会被调用一次
     * 在服务器关闭时被调用
     * */
    @Override
    public void destroy() {
        System.out.println("destroy(0");
    }
}
