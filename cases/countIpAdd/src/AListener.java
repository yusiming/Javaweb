/**
 * @Auther: yusiming
 * @Date: 2018/8/19 15:51
 * @Description:
 */

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.LinkedHashMap;
import java.util.Map;

@WebListener()
public class AListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    public AListener() {
    }

    public void contextInitialized(ServletContextEvent sce) {
        // 在服务器启动时，创建一个map，用来统计访问量，保存到servletContext中，
        // 方便显示
        Map<String, Integer> map = new LinkedHashMap<>();
        // 得到ServletContext
        ServletContext servletContext = sce.getServletContext();
        // 保存map
        servletContext.setAttribute("map", map);
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }

    public void sessionCreated(HttpSessionEvent se) {

    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
