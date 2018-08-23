package yu.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import yu.commons.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Auther: yusiming
 * @Date: 2018/8/21 14:54
 * @Description:
 */
@WebServlet(name = "Upload2Servlet", urlPatterns = {"/Upload2Servlet"})
public class Upload2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        // 得到工厂
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        // 得到解析器
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        // 限制整个表单大小为1Mb
        servletFileUpload.setSizeMax(1024 * 1024);
        // 限制单个文件的大小为100k，这个语句必须在解析开始之前，若文件大小超出范围，parseRequest方法抛出异常
        servletFileUpload.setFileSizeMax(1024 * 100);
        try {
            // 得到集合
            List list = servletFileUpload.parseRequest(request);
            FileItem item = (FileItem) list.get(1);
            // 文件打散，先得到很目录
            String root = this.getServletContext().getRealPath("/WEB-INF/files/");
            // 在root下生成两级目录，先得到文件名
            String fileName = item.getName();
            //int index = fileName.lastIndexOf("\\");
            // 若文件名中包含盘符，截取字串
            /*if (index != -1) {
                fileName = fileName.substring(index + 1);
            }*/
            // 保存文件名
            String saveName = CommonUtils.uuid() + "_" + fileName;
            // 得到文件名对应的hashcode
            int code = saveName.hashCode();
            // 得到十六进制
            String hex = Integer.toHexString(code);
            // 获取hex前两个字母
            File dirFile = new File(root + hex.charAt(0) + "\\" + hex.charAt(1));
            // 创建目录
            boolean mkdirs = dirFile.mkdirs();
            // 生成文件
            File destFile = new File(dirFile, saveName);
            item.write(destFile);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
