package XML解析andSAX解析;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;


//在写入和读取的如果编码不一致的话  就会导致乱码问题
//再写入时 是通过流写入的
//XMLWriter writer=new XMLWriter(new FileWriter("JavaWeb2/src/student_copy.xml"),format);
//===========================================>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
// XMLWriter writer=new XMLWriter(new OutputStreamWriter(new FileOutputStream("JavaWeb2/src/student——copy.xml"),"UTF-8"),format);

//读取： <？xml version="1.0" encoding="UTF-8"?>
  //读取 ：  format.setEncoding("UTF-8");   设置解码方式

//简单的解决方式  ：  用字节流写入  不用字符流
//XMLWriter writer=new XMLWriter(new FileOutputStream("JavaWeb2/src/student_copy.xml"),format);


public class DOM4J_4
{
    //增加一个学生   itcast_0003   杰克  20
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
        studentEle.addElement("name").addText("杰克");
        studentEle.addElement("age").addText("20");
        studentEle.addElement("sex").addText("male");
        //回写：
        // 创建格式化器
        OutputFormat format=OutputFormat.createPrettyPrint();
        //创建写入器
        XMLWriter writer=new XMLWriter(new OutputStreamWriter(new FileOutputStream("JavaWeb2/src/student_copy.xml"),"UTF-8"),format);
        //将文档写入文件
        writer.write(document);
        //关闭资源
        writer.close();
    }
}
