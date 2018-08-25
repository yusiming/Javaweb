package yu.servlet;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Auther: yusiming
 * @Date: 2018/8/24 11:18
 * @Description:
 */
@WebServlet(name = "ProvinceServlet", urlPatterns = {"/ProvinceServlet"})
public class ProvinceServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        response.setContentType("text/html;charset=utf-8");
        SAXReader reader = new SAXReader();
        try {
            InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("/china.xml");
            Document read = reader.read(resourceAsStream);
            Element rootElement = read.getRootElement();
            List<Element> provinces = rootElement.elements("province");
            StringBuilder provinceNames = new StringBuilder();
            for (int i = 0; i < provinces.size(); i++) {
                provinceNames.append(provinces.get(i).attributeValue("name"));
                if (i < provinces.size() - 1) {
                    provinceNames.append(",");
                }
            }
            response.getWriter().print(provinceNames);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
