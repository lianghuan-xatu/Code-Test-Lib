package XML解析andSAX解析;



///删除学号为itcast_001的学生

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.Iterator;

public class DOM4J_5
{
    public static void main(String[] args) throws DocumentException, IOException {

        //创建解析器
        SAXReader reader = new SAXReader();
        //使用解析器加载文档
        Document document = reader.read(new File("JavaWeb2/src/student.xml"));
        //获得根元素
        /*Element root = document.getRootElement();
        //获得所有student子元素
        //遍历，判断number属性的值是否是itcast_001
        //以上为普通方法    代码量较大
        Iterator<Element> it = root.elementIterator("student");
        while (it.hasNext()) {
            Element student = it.next();
            //获得student元素上的number属性
            String number = student.attributeValue("number");
            if(number.equals("it_cast_0001")){
                student.getParent().remove(student);
            }
        }
        //回写：
        // 创建格式化器
        OutputFormat format=OutputFormat.createPrettyPrint();
        //创建写入器
        XMLWriter writer=new XMLWriter(new OutputStreamWriter(new FileOutputStream("JavaWeb2/src/student.xml"),"UTF-8"),format);
        //将文档写入文件
        writer.write(document);
        //关闭资源
        writer.close();
*/

        //新的方式

        //在此之前 必须添加在DOM4J框架lib目录下的jaxen-1.1-beta-6.jar包

        //创建xpath表达式
        String xpath="//student[@number='it_cast_0001']";
         //根据xpath找到要删除的元素
        Element stuEle= (Element) document.selectSingleNode(xpath);
          //删除
        stuEle.getParent().remove(stuEle);
        //回写：
        // 创建格式化器
        OutputFormat format=OutputFormat.createPrettyPrint();
        //创建写入器
        XMLWriter writer=new XMLWriter(new OutputStreamWriter(new FileOutputStream("JavaWeb2/src/student.xml"),"UTF-8"),format);
        //将文档写入文件
        writer.write(document);
        //关闭资源
        writer.close();
    }

}
