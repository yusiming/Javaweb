package yu.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by yu on 2018/7/18
 */
public class Person {
    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        saxParser.parse("dom/yu.file/person.xml",new myDefaultHander3());
    }
}
class myDefaultHander1 extends DefaultHandler {
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print("<" + qName + ">");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.print("<" + qName + ">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.print(new String(ch,start,length));
    }
}
class myDefaultHander2 extends DefaultHandler {
    boolean flag = false;
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("name")) {
            flag = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        flag = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (flag == true) {
            System.out.println(new String(ch,start,length));
        }
    }
}
class myDefaultHander3 extends DefaultHandler {
    boolean flag = false;
    int index = 0;
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("name")) {
            flag = true;
            index++;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        flag = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if ((flag == true) && index == 2) {
            System.out.println(new String(ch,start,length));
        }
    }
}
