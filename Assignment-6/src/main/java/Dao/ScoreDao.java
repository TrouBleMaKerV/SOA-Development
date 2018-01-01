package Dao;

import SCORE.Edit;
import SCORE.Score;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ScoreDao {

    public ArrayList<Score> getScore(String sid) {
        ArrayList<Score> scores=new ArrayList<Score>();

        try {
            File xmlfile=new File("D:\\chromeDownload\\onlineStockWebSample01\\Assignment-6\\src\\main\\XML文档3.xml");

            SAXReader reader = new SAXReader();
            Document doc = reader.read(xmlfile);

            Node root=doc.selectSingleNode("/课程成绩列表");
            List list=root.selectNodes("课程成绩");
            for(Object o:list){

                Element e = (Element) o;
                String sid1=e.element("成绩").elementText("学号");
                if (sid.equals(sid1)){
                    Score score=new Score();
                    score.setSid(sid1);
                    score.setScore(Integer.parseInt(e.element("成绩").elementText("得分")));
                    score.setCid(e.elementText("课程编号"));
                    score.setCname(e.elementText("课程名称"));
                    score.setType(e.elementText("成绩性质"));
                    scores.add(score);
                }
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
        return scores;
    }

    public String modifyScore(Edit edit) {
        String message="";
        String sid=edit.getSid();
        String cid=edit.getCid();
        String type=edit.getCourseType();
        int temp=0;
        int score=edit.getScore();
        try {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(new File("D:\\IDEAprojects\\Assignment-6\\src\\main\\XML文档3.xml"));
            /** 修改内容之一: 如果book节点中show属性的内容为yes,则修改成no */
            /** 先用xpath查找对象 */
            Element nameElem=document.getRootElement().element("课程成绩");
            if(nameElem.element("课程编号").getText().equals(cid)
                    && nameElem.element("成绩性质").getText().equals(type)
                    && nameElem.element("成绩").element("学号").getText().equals(sid)){
                System.out.println("符合条件");
                nameElem.element("成绩").element("得分").setText(String.valueOf(score));
                temp++;
            }

            //指定文件输出的位置
            FileOutputStream out =new FileOutputStream("D:\\IDEAprojects\\Assignment-6\\src\\main\\XML文档3.xml");
            // 指定文本的写出的格式：
            OutputFormat format= OutputFormat.createPrettyPrint();   //漂亮格式：有空格换行
            format.setEncoding("UTF-8");
            //1.创建写出对象
            XMLWriter writer=new XMLWriter(out,format);
            //2.写出Document对象
            writer.write(document);
            //3.关闭流
            writer.close();

            if(temp==0){
                message="符合条件 学号="+sid+" 课程编号="+cid+" 成绩性质="+type+" 的成绩记录不存在";
            }
            else{
                message="";
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return message;
    }


    public static void main(String[] args){
        ScoreDao scoreDao=new ScoreDao();
        Edit edit=new Edit("151250131","25010350","平时成绩",42);
        String  res=scoreDao.modifyScore(edit);
        System.out.println(res);
    }
}
