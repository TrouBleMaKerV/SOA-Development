package Dao;

import Score.Score;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ScoreDao {

    public ArrayList<Score> getScore(String sid) {
        ArrayList<Score> scores=new ArrayList<Score>();

        try {
            /*
             * 1. 得到Docuembnt
             */
            // 创建解析器
            File xmlfile=new File("D:\\IDEAprojects\\Assignment-5\\src\\main\\java\\XML文档3.xml");

            SAXReader reader = new SAXReader();
            // 调用读方法，得到Document
            Document doc = reader.read(xmlfile);

            Node root=doc.selectSingleNode("/课程成绩列表");
            List list=root.selectNodes("课程成绩");
//            List list=root.selectNodes("课程成绩/成绩/学号='"+sid+"'");
            int k=0;
            for(Object o:list){

                Element e = (Element) o;
                String sid1=e.element("成绩").elementText("学号");
                if (sid.equals(sid1)){
                    k++;
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

    public Boolean modifyScore(String sid, int score) {
        return null;
    }

    public static void main(String[] args){
        ScoreDao scoreDao=new ScoreDao();
        ArrayList<Score> scores=new ArrayList<Score>();scores=scoreDao.getScore("151250004");
        for(int i=0;i<scores.size();i++){
            Score ss=scores.get(i);
            System.out.println(ss.getType());
        }
        System.out.println(scores.size());
    }
}
