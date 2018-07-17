package yu.dom;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * 使用dom方式实现查询操作
 * Created by yu on 2018/7/17
 */
public class Person {
    public static void main(String[] args) throws Exception {
//        selectNames();
//        selectSingeName();
//        addSex();
//        modifySex();
//        deleteSex();
        traverseDocument();
    }

    public static void selectNames() throws Exception {
        //得到DocumentBuilderFactory的实例
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //得到DocumentBuilder的实例
        DocumentBuilder builder = factory.newDocumentBuilder();
        //得到document对象
        Document document = builder.parse("dom/yu.file/person.xml");
        //得到name标签的NodeList
        NodeList nameList = document.getElementsByTagName("name");
        //遍历NodeLIst
        for (int i = 0; i < nameList.getLength(); i++) {
            System.out.println(nameList.item(i).getTextContent());
        }
    }

    public static void selectSingeName() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("dom/yu.file/person.xml");
        NodeList nameList = document.getElementsByTagName("name");
        System.out.println(nameList.item(0).getTextContent());
    }

    public static void addSex() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("dom/yu.file/person.xml");
        Node p1 = document.getElementsByTagName("p1").item(0);
        //创建sex节点
        Element sex = document.createElement("sex");
        Text textNode = document.createTextNode("男");
        sex.appendChild(textNode);
        p1.appendChild(sex);
        //回写xml
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(new DOMSource(document), new StreamResult("dom/yu.file/person.xml"));
    }

    public static void modifySex() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("dom/yu.file/person.xml");
        Node sex = document.getElementsByTagName("sex").item(0);
        sex.setTextContent("男");
        //回写xml
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(new DOMSource(document), new StreamResult("dom/yu.file/person.xml"));
    }

    public static void deleteSex() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("dom/yu.file/person.xml");
        Node sex = document.getElementsByTagName("sex").item(0);
        Node parentNode = sex.getParentNode();
        parentNode.removeChild(sex);
        //回写xml
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(new DOMSource(document), new StreamResult("dom/yu.file/person.xml"));
    }
    public static void traverseDocument() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("dom/yu.file/person.xml");
        f(document);
    }

    private static void f(Node node) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            System.out.println(node.getNodeName());
        }
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            f(item);
        }
    }

}
