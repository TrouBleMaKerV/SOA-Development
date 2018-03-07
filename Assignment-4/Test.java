import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by panlingxiao on 2017/6/5.
 * 使用JAXP解析一份无效的XML文档(即满足相应DTD和Schema定义的元素规则)，
 */
public class Test {

    //定义两个常量，注意：这两个常量是固定值
    static final String JAXP_SCHEMA_LANGUAGE =
            "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
    static final String W3C_XML_SCHEMA =
            "http://www.w3.org/2001/XMLSchema";

    public static void main(String[] args) throws Exception{
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        //设置解析器在解析文档的时候校验文档
        builderFactory.setValidating(true);
        //通过指定factory的属性，确定使用Schema进行校验
        builderFactory. setAttribute(JAXP_SCHEMA_LANGUAGE,"D:\\IDEAprojects\\SOA-Development\\Assignment-2\\ScoreList.xsd");
        //让解析器支持命名空间
        builderFactory.setNamespaceAware(true);

        DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
        //添加ErrorHandler,将解析的异常手动抛出
        documentBuilder.setErrorHandler(new ErrorHandler() {
            @Override
            public void warning(SAXParseException exception) throws SAXException {
                System.out.println("warning");
                throw  exception;
            }

            @Override
            public void error(SAXParseException exception) throws SAXException {
                System.out.println("error");
                throw  exception;
            }

            @Override
            public void fatalError(SAXParseException exception) throws SAXException {
                System.out.println("fatal");
                throw  exception;
            }
        });

        //解析文档
        Document document = documentBuilder.parse(Test.class.getClassLoader().getResourceAsStream("D:\\IDEAprojects\\SOA-Development\\Assignment-4\\XML文档4.xml"));
        System.out.println(document);
    }
}
