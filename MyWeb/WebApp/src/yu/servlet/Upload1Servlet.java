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
 * @Date: 2018/8/21 13:34
 * @Description:
 */
@WebServlet(name = "Upload1Servlet", urlPatterns = {"/Upload1Servlet"})
public class Upload1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // servletFileUpload.setHeaderEncoding("utf-8")；优先级高于下面的
        // fileUpload内部会调用，request.getCharacterEncoding("utf-8")获取编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        /*
         * 上传文件步骤
         * 1.得到工厂
         * 2.得到解析器
         * 3.解析request，得到list集合
         * 4.遍历集合
         */
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        try {
            List list = servletFileUpload.parseRequest(request);
            FileItem item1 = (FileItem) list.get(0);
            FileItem item2 = (FileItem) list.get(1);
            System.out.println("普通表单项；" + item1.getFieldName() + item1.getString("utf-8"));
            System.out.println("文件表单项：" + "文件名：" + item2.getName() + "文件类型：" +
                    item2.getContentType() + "文件大小 " + item2.getSize());
            // 保存文件
            String filename = CommonUtils.uuid() + "_" + item2.getName();
            File file = new File("d:/" + filename);
            item2.write(file);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
