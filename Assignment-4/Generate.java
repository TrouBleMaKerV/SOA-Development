
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.awt.print.Book;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class Generate {
    public static List<CourseList> saxParser(File file){
        try{
            // 1.创建解析工厂
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();// 获取单例
            // 2.得到解析器
            SAXParser saxParser = saxParserFactory.newSAXParser();
            // 3.得到内容处理器
           ScoreSAX saxHandler=new ScoreSAX();
            // 4.解析器绑定内容处理器，并解析xml文件
            saxParser.parse(file, saxHandler);

//            List<CourseList> courseLists=saxHandler.getCourseList();
            List<CourseList> courseLists=saxHandler.getFailLists();

            return  courseLists;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;

    }

    public static void createXML(List<CourseList> courseLists) {

        try {
            // 保存创建的saxbooks.xml
            Result result = new StreamResult(new FileOutputStream(new File("D:\\IDEAprojects\\SOA-Development\\Assignment-4\\XML文档4.xml")));
            // 创建工厂
            SAXTransformerFactory factory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
            TransformerHandler handler = factory.newTransformerHandler();
            Transformer info = handler.getTransformer();
            // 是否自动添加额外的空白
            info.setOutputProperty(OutputKeys.INDENT, "yes");
            // 设置字符编码
            info.setOutputProperty(OutputKeys.ENCODING, "utf-8");
            info.setOutputProperty(OutputKeys.VERSION, "1.0");

            handler.setResult(result);
            // 开始xml
            handler.startDocument();
            AttributesImpl impl = new AttributesImpl();
//            impl.clear();
            handler.startElement("","","课程成绩列表",impl);
            for(int i=0;i<courseLists.size();i++){
                CourseList courseList = courseLists.get(i);

                handler.startElement("", "", "课程成绩", impl);
                handler.startElement("", "", "成绩", impl);
                handler.startElement("", "", "学号", impl);
                String student_id=courseList.getScoreItem().getStudent_id();
                handler.characters(student_id.toCharArray(), 0, student_id.length());
                handler.endElement("", "", "学号");
                handler.startElement("", "", "得分", impl);
                int score=courseList.getScoreItem().getScore();
                String grade=String.valueOf(score);
                handler.characters(grade.toCharArray(), 0,grade.length());
                handler.endElement("", "", "得分");
                handler.endElement("", "", "成绩");
                handler.endElement("", "", "课程成绩");

            }
            //生成</bookstore>
            handler.endElement("", "", "课程成绩列表");
            handler.endDocument();
            System.out.println("over");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args)
    {
        List<CourseList> faillists=saxParser(new File("D:\\IDEAprojects\\SOA-Development\\Assignment-4\\XML文档3.xml"));
        createXML(faillists);
    }
}
