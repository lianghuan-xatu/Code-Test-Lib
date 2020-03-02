package Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JacksonTest {
    //Java对象转为JSON字符串
    @Test
    public void test1() throws IOException {
        //1、创建Person对象
        Person p=new Person();
        p.setName("张三");
        p.setAge(18);
        p.setGender("男");
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
        mapper.writeValue(new File("d://a.txt"),p);

        //writeValue将数据关联到Writer中
        mapper.writeValue(new FileWriter("d://a.txt"),p);
    }

}
