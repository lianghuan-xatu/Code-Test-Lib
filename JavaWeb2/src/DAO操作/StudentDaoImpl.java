package DAO操作;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public void addStudent(Student stu) {
       // 构建解析器
        //加载文档获得doc
        //根据doc获得root元素
        //在student元素下添加子元素，属性
        //在student元素下添加name age  sex添加文本
        //回写



       try{

           //根据要添加的学生，如果存在直接返回
           Student stu2=getByNumber(stu.getNumber());
           if(stu2!=null){
               throw new RuntimeException("学号已经存在");
           }
           Document doc = getDocument();
           Element root=doc.getRootElement();
           Element stuEle=root.addElement("student").addAttribute("number",stu.getNumber());
           stuEle.addElement("name").addText(stu.getName());
           stuEle.addElement("age").addText(stu.getAge()+"");
           stuEle.addElement("sex").addText(stu.getSex());
           storage(doc);
       }catch (DocumentException e){
            throw new RuntimeException("文件未找到！,或xml格式错误");
        }catch (UnsupportedEncodingException e){
           throw new RuntimeException("编码设置无！");
       }catch (FileNotFoundException e){
           throw new RuntimeException("文件未找到！");
       } catch (IOException e) {
           e.printStackTrace();

       }
    }

    private void storage(Document doc) throws IOException {
        OutputFormat format=OutputFormat.createPrettyPrint();
        XMLWriter writer=new XMLWriter(new FileOutputStream("D://IDEA WORKSPACE2/JavaWeb2/src/student.xml"),format);
        writer.write(doc);                                //      D://IDEA WORKSPACE2/JavaWeb2/
        writer.close();
    }

    private Document getDocument() throws DocumentException {
        SAXReader reader=new SAXReader();
        return reader.read(new File("D://IDEA WORKSPACE2/JavaWeb2/src/student.xml"));
    }

    @Override
    public void removeStudent(String number) {
        try {
            Document doc=getDocument();
            String xpath="//student[@number='"+number+"']";
            Element stuEle= (Element) doc.selectSingleNode(xpath);
            if(stuEle==null){
                return;
            }else{
                stuEle.getParent().remove(stuEle);
                storage(doc);
            }
        } catch (DocumentException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeStudent(Student stu) {
      removeStudent(stu.getNumber());
    }

    @Override
    public void updateStudent(Student stu) {
          removeStudent(stu);
          addStudent(stu);
    }

    @Override
    public Student getByNumber(String number) {
        //获得文档
        //书写xpath表达式
        //查找student元素，判断是否找到
        try {
            Document doc=getDocument();
            String xpath="//student[@number='"+number+"']";
            Element stuEle=(Element)doc.selectSingleNode(xpath);
            if(stuEle==null){
                return null;
            }else{
                Student stu=new Student(number,stuEle.elementText("name"),stuEle.elementText("age"),stuEle.elementText("sex"));
                return stu;
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Student> getAllStudent() {
        return null;
    }
}
