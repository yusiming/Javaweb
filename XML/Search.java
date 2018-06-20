import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class Search {
    public static void main(String[] args) throws Exception {
        Document document = getDomElement("D:/Work/src/person.xml");
        NodeList list = getNodeList(document,"name");
        //遍历name节点
        //for (int i = 0; i < list.getLength(); i++) {
          //  Node node = list.item(i);
           // System.out.println(node.getTextContent());
        //}
        //查询某个特定节点
       // Node node1 = list.item(0);
        //System.out.println(node1.getTextContent());
        //添加节点
        //addNode(document,list,2,"sex","男");
        //回写xml
        //rewrite(document,"D:/Work/src/person.xml");
        //得到sex节点List，删除节点
        //NodeList list1 = getNodeList(document,"sex");
        //removeNode(list1,2);
        //rewrite(document,"D:/Work/src/person.xml");
        //Node node = list.item(0);
        //changeContent(node,"虞");
        //rewrite(document,"D:/Work/src/person.xml");
        listElement(document);
    }
    //得到某个xml文件的Document对象
    public static Document getDomElement(String s) throws Exception {
        //得到DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //得到DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();
        //得到Document对象
        Document document = builder.parse(s);
        return document;
    }
    //得到某个Document对象的Nodelist
    public static NodeList getNodeList(Document document, String nodeName) {
        NodeList list = document.getElementsByTagName(nodeName);
        return list;
    }
    //添加节点
    public static void addNode(Document document,NodeList list,int index,String nodeName,String textContent) {
        Node node = list.item(index-1);
        Element element = document.createElement(nodeName);
        Text textNode = document.createTextNode(textContent);
        element.appendChild(textNode);
        node.appendChild(element);
    }
    //回写xml
    public  static void rewrite(Document document,String s) throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        transformer.transform(new DOMSource(document),new StreamResult(s));
    }
    //删除节点
    public static void removeNode(NodeList list,int index) {
        Node node = list.item(index-1);
        Node parentNode = node.getParentNode();
        parentNode.removeChild(node);
    }
    public static void changeContent(Node node,String s) {
        node.setTextContent(s);
    }
    //遍历节点
    public static void listElement(Node node) {
        NodeList list = node.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            if (list.item(i).getNodeType() == Node.ELEMENT_NODE) {
                System.out.println(list.item(i).getNodeName());
            }
            listElement(list.item(i));
        }

    }
}