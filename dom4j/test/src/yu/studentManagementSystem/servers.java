package yu.studentManagementSystem;

import org.dom4j.Document;
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
public class servers {
    public static void main(String[] args) throws Exception {
        Student student = selectStudent("003");
        System.out.println(student.toString());
    }

    public static void addStudent(Student student) throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read("test/src/student.xml");
        Element rootElement = document.getRootElement();
        Element stu = rootElement.addElement("stu");
        Element id = stu.addElement("id");
        Element name = stu.addElement("name");
        Element age = stu.addElement("age");
        id.setText(student.getId());
        name.setText(student.getName());
        age.setText(student.getAge());
        //回写xml
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(new FileOutputStream("test/src/student.xml"), format);
        writer.write(document);
        writer.close();
    }

    public static void removeStudent(String delId) throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read("test/src/student.xml");
        Element rootElement = document.getRootElement();
        List<Node> list = document.selectNodes("//id");
        for (Node node : list) {
            if (node.getText().equals(delId)) {
                Element stu = node.getParent();
                Element student = stu.getParent();
                student.remove(stu);
            }
        }
        //回写
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(new FileOutputStream("test/src/student.xml"), format);
        writer.write(document);
        writer.close();
    }

    public static Student selectStudent(String selId) throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read("test/src/student.xml");
        List<Node> list = document.selectNodes("//id");
        for (Node node : list) {
            if (node.getText().equals(selId)) {
                Element stu = node.getParent();
                String selName = stu.element("name").getText();
                String selAge = stu.element("age").getText();
                Student student = new Student(selId, selName, selAge);
                return student;
            }
        }
        return null ;
    }
}
