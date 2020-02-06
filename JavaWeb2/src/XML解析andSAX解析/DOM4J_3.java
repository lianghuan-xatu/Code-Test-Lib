package XML解析andSAX解析;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DOM4J_3 {
    //增加一个学生   itcast_0003   jack  20
public static void main(String[] args) throws DocumentException, IOException {
    //创建解析器
    SAXReader reader = new SAXReader();
    //使用解析器加载文档
    Document document = reader.read(new File("JavaWeb2/src/student.xml"));
    //获得根元素
    Element root=document.getRootElement();
    //为根元素添加student 子元素和属性
    Element studentEle= root.addElement("student").addAttribute("number","itcast_0003");
    //为student添加name   age   sex   子元素和内容
    studentEle.addElement("name").addText("jack");
    studentEle.addElement("age").addText("20");
    studentEle.addElement("sex").addText("male");
    //回写：
       // 创建格式化器
        OutputFormat format=OutputFormat.createPrettyPrint();
       //创建写入器
        XMLWriter writer=new XMLWriter(new FileWriter("JavaWeb2/src/student.xml"),format);
          //将文档写入文件
        writer.write(document);
        //关闭资源
          writer.close();
}
}
