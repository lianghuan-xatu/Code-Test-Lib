package XML解析andSAX解析;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.File;

//DOM4J是一个用来解析XML的框架
//DOM for java   ====>  模仿DOM，DOM4J可以看作是对原生DOM的优化
//框架是啥？？？
//就是由很多很多的类构成的，共同完成一个大的功能
//DOM4J与JDOM
public class DOM4J {
    //将xml文档加载，获得document对象
    //将document对象，以字符串的形式输出
    public static void main(String[] args) throws DocumentException {
        //创建解析器
        SAXReader reader = new SAXReader();
        //使用解析器加载文档
        Document document = reader.read(new File("JavaWeb2/src/student.xml"));
        //将文档对象转换成String
        String xml=document.asXML();
        System.out.println(xml);


    }


}