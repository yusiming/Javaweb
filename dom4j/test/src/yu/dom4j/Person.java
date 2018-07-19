package yu.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by yu on 2018/7/18
 */
public class Person {
    public static void main(String[] args) throws Exception {
        selectFirstNamesWithxpath();
    }

    public static void selectNames() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read("test/src/person.xml");
        Element rootElement = document.getRootElement();
        List<Element> p1List = rootElement.elements("p1");
        for (Element element : p1List) {
            Element name = element.element("name");
            System.out.println(name.getText());
        }
    }

    public static void selectFirstName() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read("test/src/person.xml");
        Element rootElement = document.getRootElement();
        Element p1 = rootElement.element("p1");
        Element name = p1.element("name");
        System.out.println(name.getText());
    }

    public static void selectSecondName() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read("test/src/person.xml");
        Element rootElement = document.getRootElement();
        List p1List = rootElement.elements("p1");
        Element secondp1 = (Element) p1List.get(1);
        Element name = secondp1.element("name");
        System.out.println(name.getText());
    }

    public static void addSex() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read("test/src/person.xml");
        Element rootElement = document.getRootElement();
        Element p1 = rootElement.element("p1");
        Element sex = p1.addElement("sex");
        sex.setText("男");
        //回写xml
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(new FileOutputStream("test/src/person.xml"), format);
        writer.write(document);
        writer.close();
    }

    public static void addSchoolBeforeAge() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read("test/src/person.xml");
        Element rootElement = document.getRootElement();
        Element p1 = rootElement.element("p1");
        List<Element> elements = p1.elements();
        Element school = DocumentHelper.createElement("school");
        school.setText("河南理工");
        elements.add(1, school);
        //回写xml
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(new FileOutputStream("test/src/person.xml"), format);
        writer.write(document);
        writer.close();
    }

    public static void modifyAge() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read("test/src/person.xml");
        Element rootElement = document.getRootElement();
        Element p1 = rootElement.element("p1");
        Element age = p1.element("age");
        age.setText("30");
        //回写
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(new FileOutputStream("test/src/person.xml"), format);
        writer.write(document);
        writer.close();
    }

    public static void removeSchool() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read("test/src/person.xml");
        Element rootElement = document.getRootElement();
        Element p1 = rootElement.element("p1");
        Element school = p1.element("school");
        p1.remove(school);
        //回写
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(new FileOutputStream("test/src/person.xml"), format);
        writer.write(document);
        writer.close();
    }

    public static void getValue() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read("test/src/person.xml");
        Element rootElement = document.getRootElement();
        Element p1 = rootElement.element("p1");
        String id1 = p1.attributeValue("id1");
        System.out.println(id1);
    }

    public static void selectNamesWithxpath() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read("test/src/person.xml");
        List<Node> list = document.selectNodes("//name");
        for (Node node : list) {
            System.out.println(node.getText());
        }
    }

    public static void selectFirstNamesWithxpath() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read("test/src/person.xml");
        //方法一
        //Node node = document.selectSingleNode("//p1[@id1='yu']/name");
        //方法二
        Node node = document.selectSingleNode("/person/p1[1]/name");
        System.out.println(node.getText());
    }
}
