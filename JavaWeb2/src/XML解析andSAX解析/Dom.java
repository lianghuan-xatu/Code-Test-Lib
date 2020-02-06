package XML解析andSAX解析;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Dom {
    //读取xml中所有学生信息并打印
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        //获取解析器工厂
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        //通过工厂获得解析器实现类
        DocumentBuilder db=factory.newDocumentBuilder();
        //使用解析器加载xml文档---》得到Document对象db
        Document doc= db.parse(new File("src/student.xml"));
        //获取所有学生元素对象
        NodeList nodeList=doc.getElementsByTagName("student");
        //遍历获取每一个学生元素对象
        for(int i=0;i<nodeList.getLength();i++){
            Element studentEle= (Element) nodeList.item(i);
            //获得number属性
            String number=studentEle.getAttribute("number");
            System.out.println(number);
            //获得学生元素对象下的name，age，sex子元素对象
            NodeList nodeList2=studentEle.getChildNodes();
            for(int x=0;x<nodeList2.getLength();x++){
                Node node=nodeList2.item(x);
                if(node.getNodeType()==Node.ELEMENT_NODE){
                        Element ele=(Element)node;   //获得name，age，sex内容
                        System.out.println(ele.getTextContent());
                }
            }
        }



    }
}
