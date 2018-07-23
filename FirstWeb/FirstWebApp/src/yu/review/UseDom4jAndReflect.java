package yu.review;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import yu.servletTest.Myservlet;

import java.util.List;

/**
 * 模拟服务器通过解析web.xml文件使用反射来创建Servlet对象
 * Created by yu on 2018/7/22
 */
public class UseDom4jAndReflect {
    public static void main(String[] args) throws Exception {
        String s = "/yu/Myservlet";
        String servletName = null;
        String servletclass = null;
        SAXReader reader = new SAXReader();
        Document document = reader.read("D:\\JavaWeb\\FirstWeb\\FirstWebApp\\web\\WEB-INF\\web.xml");
        Element rootElement = document.getRootElement();
        List<Element> servletMappingList = rootElement.elements("servlet-mapping");
        for (Element element : servletMappingList) {
            //通过urlpattern得到servletName
            if (element.element("url-pattern").getText().equals(s)) {
                Element servletNameElement = element.element("servlet-name");
                servletName = servletNameElement.getText();
                System.out.println("servletName" + servletName);
            }
        }
        List<Element> servletList = rootElement.elements("servlet");
        for (Element element : servletList) {
            //通过servletName得到servletclass
            if (element.element("servlet-name").getText().equals(servletName)) {
                Element servletClassElement = element.element("servlet-class");
                servletclass = servletClassElement.getText();
                System.out.println("servletclass" + servletclass);
            }
        }
        //使用反射得到Servet对象
        Class aClass = Class.forName(servletclass);
        Myservlet myservlet = (Myservlet) aClass.getDeclaredConstructor().newInstance();
        myservlet.getServletInfo();
    }
}
