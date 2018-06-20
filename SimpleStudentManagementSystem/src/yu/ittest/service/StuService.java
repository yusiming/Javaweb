package yu.ittest.service;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import yu.ittest.vo.Student;
import java.io.FileOutputStream;
import java.util.List;

public class StuService {
    private static String path = "D:/SimpleStudentManagementSystem/src/student.xml";
    //添加节点
    public static void addStu(Student student) throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(path);
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
        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(path),format);
        xmlWriter.write(document);
        xmlWriter.close();
    }
    //根据学生ID删除数据
    public static void deleteStu(String delId) throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(path);
        List<Node> list = document.selectNodes("//id");
        for (Node node :list) {
            if (node.getText().equals(delId)) {
                Element stu = node.getParent();
                Element student = stu.getParent();
                student.remove(stu);
            }
        }
        //回写xml
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(path),format);
        xmlWriter.write(document);
        xmlWriter.close();
    }
    //根据学生ID查询数据
    public static Student getStu(String selId) throws Exception {
        Student student = new Student();
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(path);
        List<Node> list = document.selectNodes("//id");
        for (Node node:list) {
            if (node.getText().equals(selId)) {
                Element stu = node.getParent();
                Element id = stu.element("id");
                Element name = stu.element("name");
                Element age = stu.element("age");
                student.setId(selId);
                student.setName(name.getText());
                student.setAge(age.getText());
            }
        }
        return student;
    }
}
