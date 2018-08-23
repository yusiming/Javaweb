package yu.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;

/**
 * @Auther: yusiming
 * @Date: 2018/8/22 10:59
 * @Description: 文件的下载
 */
@WebServlet(name = "Download1Servlet", urlPatterns = {"/Download1Servlet"})
public class Download1Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // 文件的mime类型
        String filename = "d:/虞四明.jpg";
        // 解决文件中文名称乱码问题的几种方法
        // 通用方法
        //String framename = new String("虞四明.jpg".getBytes("GBK"), "ISO-8859-1");
        //大部分浏览器可以使用
        //String framename = URLEncoder.encode("虞四明.jpg", "utf-8");
        String framename = filenameEncoding("虞四明.jpg", request);
        String mimeType = this.getServletContext().getMimeType(filename);
        // 设置两个响应头
        response.setHeader("Content-Type", mimeType);
        response.setHeader("Content-Disposition", "attachment;filename=" + framename);
        // 设置流
        FileInputStream inputStream = new FileInputStream(filename);
        ServletOutputStream outputStream = response.getOutputStream();
        // copy两个流
        IOUtils.copy(inputStream, outputStream);
        inputStream.close();
    }

    public static String filenameEncoding(String filename, HttpServletRequest request) {
        String agent = request.getHeader("User-Agent");
        try {
            if (agent.contains("Firefox")) {
                filename = "=?UTF-8?B?" + Base64.getEncoder().encodeToString(filename.getBytes("utf-8")) + "?=";
                return filename;
            } else {
                filename = URLEncoder.encode(filename, "utf-8");
                System.out.println(filename);
                return filename;
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
