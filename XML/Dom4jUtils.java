import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import java.io.FileOutputStream;

public class Dom4jUtils {
    //根据传入的xml文件返回该文件的document对象
    public static Document getDocument(String path) {
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(path);
            return document;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }
    //回写xml方法
    public static void newXmlWriter(String path,Document document) {
        OutputFormat format = OutputFormat.createPrettyPrint();
        try {
            XMLWriter writer = new XMLWriter(new FileOutputStream(path),format);
            writer.write(document);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
