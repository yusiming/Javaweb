import org.dom4j.*;

import java.util.List;

public class Dom4jTest {
    static String path = "D:/Work/src/p1.xml";
    public static void main(String[] args) throws Exception {
        getFirstNameWithxpath();
    }
    //查询xml中所有name元素的值
    public static void selectName() throws Exception {
        //创建解析器得到document
        Document document = Dom4jUtils.getDocument(path);
        //得到根节点
        Element rootElement = document.getRootElement();
        //得到包含所有p1的一个List集合
        List<Element> list = rootElement.elements("p1");
        //遍历list
        for (Element element:list) {
            Element nameElement= element.element("name");
            System.out.println(nameElement.getText());
        }
    }
    //得到第一个name的值
    public  static void getFirstName() throws DocumentException {
        //创建解析器得到document
        Document document = Dom4jUtils.getDocument(path);
        //得到根节点
        Element rootElement = document.getRootElement();
        //得到第一个p1
        Element firstP1Element = rootElement.element("p1");
        //得到p1下面的name
        Element nameElement = firstP1Element.element("name");
        System.out.println(nameElement.getText());
    }
    //得到第二个name元素的值
    public static void getSecondName() throws DocumentException {
        Document document = Dom4jUtils.getDocument(path);
        Element rootElement = document.getRootElement();
        List<Element> list = rootElement.elements("p1");
        Element secondP1Element = list.get(1);
        Element secondNameElement = secondP1Element.element("name");
        System.out.println(secondNameElement.getText());
    }
    //使用dom4j实现添加操作
    public  static void addSex() throws DocumentException{
        Document document = Dom4jUtils.getDocument(path);
        Element rootElement = document.getRootElement();
        Element p1Element = rootElement.element("p1");
        Element sexElement = p1Element.addElement("sex");
        sexElement.setText("男");
        //回写xmL
        Dom4jUtils.newXmlWriter("D:/Work/src/p1.xml",document);
    }
    //在特定位置添加元素，如在第一个p1的子元素age之前添加一个<school>标签
    public static void addSchoolBeforeAge() throws DocumentException {
        Document document = Dom4jUtils.getDocument(path);
        Element rootElement = document.getRootElement();
        Element p1Element = rootElement.element("p1");
        List<Element> list = p1Element.elements();
        Element schoolElement = DocumentHelper.createElement("school");
        schoolElement.setText("河南理工");
        list.add(1,schoolElement);
        //回写xml
        Dom4jUtils.newXmlWriter(path,document);
    }
    public static void modifyAge() {
        Document document = Dom4jUtils.getDocument(path);
        Element rootElement = document.getRootElement();
        Element q1element = rootElement.element("p1");
        Element age = q1element.element("age");
        age.setText("30");
        Dom4jUtils.newXmlWriter(path,document);
    }
    public static void deleteSchool() {
        Document document = Dom4jUtils.getDocument(path);
        Element rootElement = document.getRootElement();
        Element p1Element = rootElement.element("p1");
        Element schoolElement = p1Element.element("school");
        p1Element.remove(schoolElement);
        Dom4jUtils.newXmlWriter(path,document);
    }
    public static void getP1Attribute() {
        Document document = Dom4jUtils.getDocument(path);
        Element rootElement = document.getRootElement();
        Element p1 = rootElement.element("p1");
        String id1 = p1.attributeValue("id1");
        System.out.println(id1);
    }
    public static void selectNameWithXpath() {
        Document document = Dom4jUtils.getDocument(path);
        List<Node> list = document.selectNodes("//name");
        for (Node node:list) {
            String s = node.getText();
            System.out.println(s);
        }
    }
    public static void getFirstNameWithxpath() {
        Document document = Dom4jUtils.getDocument(path);
        Node node = document.selectSingleNode("//p1[@id1='111']/name");
        String text = node.getText();
        System.out.println(text);
    }
}