package yu.baseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @Auther: yusiming
 * @Date: 2018/8/10 17:03
 * @Description: 在service方法中根据传递的参数，调用不同的方法，
 */
public class BaseServlet extends HttpServlet {
    /**
     * @Description: 重写HttpServlet的service方法，让其他类来继承此类，实现代码的优化
     * @auther: yusiming
     * @date: 17:53 2018/8/10
     * @param: [req, resp]
     * @return: void
     */
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        // 得到参数
        String methodName = req.getParameter("method");
        // 若没有传递参数，则抛出异常
        if (methodName == null || methodName.trim().isEmpty()) {
            throw new RuntimeException("请传递method参数");
        }
        Method method = null;
        try {
            // 根据参数得到method对象，
            method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
        } catch (NoSuchMethodException e) {
            //若方法不存在抛出异常
            throw new RuntimeException("方法" + methodName + "不存在");
        }
        try {
            // 调用此方法，根据方法返回值，决定是否转发或者重定向，还是什么都不做
            String result = (String) method.invoke(this, req, resp);
            if (result == null || result.trim().isEmpty()) {
                return;
            }
            // 若返回值中不包含”:“ 冒号，那么默认是转发
            if (!result.contains(":")) {
                req.getRequestDispatcher(result).forward(req, resp);
            } else {
                // 若不包含”:“，则切分字符串，判断
                int i = result.indexOf(":");
                String way = result.substring(0, i);
                String path = result.substring(i + 1);
                // "r" 代表重定向，"f"代表转发
                if ("r".equals(way)) {
                    resp.sendRedirect(req.getContextPath() + path);
                } else if ("f".equals(way)) {
                    req.getRequestDispatcher(path).forward(req, resp);
                } else {
                    //若方法返回值无法识别，抛出异常
                    throw new RuntimeException("指定的操作：" + way + "不存在");
                }
            }
        } catch (Exception e) {
            //若调用方法时出现异常，则抛出异常，方法内部抛出异常
            System.out.println("方法内部抛出异常");
            throw new RuntimeException(e);
        }

    }
}
