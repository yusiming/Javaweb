package yu.servlet;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: yusiming
 * @Date: 2018/8/24 11:18
 * @Description:
 */
@WebServlet(name = "CityServlet", urlPatterns = {"/CityServlet"})
public class CityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/xml;charset=utf-8");
        String province = request.getParameter("province");
        SAXReader reader = new SAXReader();
        try {
            InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("/china.xml");
            Document document = reader.read(resourceAsStream);
            Element proElement = (Element) document.selectSingleNode("//province[@name='" + province +"']");
            String xml = proElement.asXML();
            response.getWriter().print(xml);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }
}
