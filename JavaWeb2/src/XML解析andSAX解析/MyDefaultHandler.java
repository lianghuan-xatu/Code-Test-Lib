package XML解析andSAX解析;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
    //DefaultHandler类实现了ContentHandler接口    这里覆盖里面 需要的方法
public class MyDefaultHandler extends DefaultHandler {
        @Override
        public void startDocument() throws SAXException {
            super.startDocument();
            System.out.println("文档解析开始");
        }

        @Override
        public void endDocument() throws SAXException {
            super.endDocument();
            System.out.println("文档解析结束");
        }

        @Override
        //前两个参数永远为空
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            super.startElement(uri, localName, qName, attributes);
            System.out.println("当前解析到"+qName+"元素");
            if(qName.equals("student")){
                String number=attributes.getValue("number");
                System.out.println(number);
            }

        }

        @Override
        //前两个参数永远为空
        public void endElement(String uri, String localName, String qName) throws SAXException {
            super.endElement(uri, localName, qName);
            System.out.println(qName+"解析结束");
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            super.characters(ch, start, length);
            String str=new String(ch,start,length);
            //过滤空白字符
            str=str.trim();
            if(str.length()>0){
                System.out.println(str);
            }
        }
    }
