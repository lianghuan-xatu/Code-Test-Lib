package XML解析andSAX解析;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;

public class DOM4J_2 {
    //将xml文档加载，获得document对象
    //将document对象，以字符串的形式输出
    public static void main(String[] args) throws DocumentException {
        //创建解析器
        SAXReader reader = new SAXReader();
        //使用解析器加载文档
        Document document = reader.read(new File("JavaWeb2/src/student.xml"));
        //查文档中的所有学生
        //获得根元素   迭代根元素下的所有student元素
        Element students=document.getRootElement();
        Iterator<Element> it= students.elementIterator("student");
        while(it.hasNext()){
            Element student=it.next();
            //获得student元素上的number属性
            String number=student.attributeValue("number");
            System.out.println(number);
            Element stuName=student.element("name");
            String name=stuName.getText();
            //再找student元素下的name   age  sex
            //获得子元素的内容
            String age=student.elementText("age");
            String sex=student.elementText("sex");
            System.out.println(name+"==>"+age+"==>"+sex);
        }



    }
}
