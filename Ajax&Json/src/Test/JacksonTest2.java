package Test;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class JacksonTest2 {
    //Java对象转为JSON字符串
    @Test
    public void test1() throws IOException {
        //1、创建Person对象
        Person p=new Person();
        p.setName("张三");
        p.setAge(18);
        p.setGender("男");
        p.setBirthday(new Date());
        //2、创建Jackson的核心对象   ObejectMapper
        ObjectMapper mapper=new ObjectMapper();
        //3、转换
      /*  转换方式：
            writeValue(参数1：obj):
                        参数1：
        File:将obj对象转换成JSON字符串，并保存到指定的文件中
         Writer:将obj对象转换成JSON字符串，并将json数据填充到字符输出流中
         OutputStream:将obj对象转换成JSON字符串，并将json数据填充到字节输出流中
           writeValueAsString(obj):将对象转换成json字符串

*/
        String json = mapper.writeValueAsString(p);
        System.out.println(json);
        //{"name":"张三","age":18,"gender":"男"}
        //writeValue，将数据写到d://a.txt文件中
     //   mapper.writeValue(new File("d://a.txt"),p);

        //writeValue将数据关联到Writer中
     //   mapper.writeValue(new FileWriter("d://a.txt"),p);
    }
    public void test3() throws IOException {
        //1、创建Person对象
        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(18);
        p1.setGender("男");
        p1.setBirthday(new Date());
        Person p2 = new Person();
        p2.setName("李四");
        p2.setAge(18);
        p2.setGender("男");
        p2.setBirthday(new Date());
        Person p3 = new Person();
        p3.setName("王麻子");
        p3.setAge(18);
        p3.setGender("男");
        p3.setBirthday(new Date());
        //创建List集合
        List<Person> ps=new ArrayList<>();
        ps.add(p1);
        ps.add(p2);
        ps.add(p3);
     
        //2、创建Jackson的核心对象   ObejectMapper
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(ps);
        System.out.println(json);
    }
    public void test4() throws IOException {
        //1、创建Person对象
      Map<String,Object> map=new HashMap<>();
      map.put("name","张三");
      map.put("age",19);
      map.put("gender","男");
        //2、创建Jackson的核心对象   ObejectMapper
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        System.out.println(json);
    }


//演示   JSON字符串为Java对象
    @Test
    public void test5() throws IOException {
       //1、初始化JSON字符串
        String json="{\"gender\":\"男\",\"name\":\"张三\",\"age\":23}";
        //2、创建Jackson的核心对象   ObejectMapper
        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);
    }
}
