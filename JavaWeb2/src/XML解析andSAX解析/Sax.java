package XML解析andSAX解析;

import org.xml.sax.SAXException;

import javax.security.sasl.SaslServerFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Sax {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //获得解析器工厂
        SAXParserFactory factory= SAXParserFactory.newInstance();
        //获得解析器
        SAXParser parser=factory.newSAXParser();
        //使用解析器加载xml文档
        parser.parse(new File("src/student.xml"),new MyDefaultHandler());



    }
}
