package edu.nju;

import edu.nju.model.scoreList.ScoreList;
import edu.nju.model.student.StudentList;
import edu.nju.translate.Generator;
import edu.nju.translate.Translate;
import edu.nju.translate.XmlParser;

import java.io.*;


/**
 * Created by Administrator on 2018/3/7.
 */
public class test {

    public static void main(String []args){
        try {
            OutputStream outputStream = new FileOutputStream(new File("result/文档2.xml"));
            String result = XmlParser.marshal(Generator.generateData());
            outputStream.write(result.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            InputStream inputStream = new FileInputStream(new File("result/文档2.xml"));
            ScoreList scoreList = Translate.convert(XmlParser.unmarshal(inputStream, StudentList.class));
            File file = new File("result/文档3.xml");
            OutputStream outputStream = new FileOutputStream(file);
            String result = XmlParser.marshal(scoreList);
            outputStream.write(result.getBytes());
            System.out.println("dsad");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            InputStream inputStream = new FileInputStream(new File("result/文档3.xml"));
            ScoreList scoreList = XmlParser.unmarshal(inputStream, ScoreList.class);
            File file = new File("result/文档4.xml");
            OutputStream outputStream = new FileOutputStream(file);
            outputStream.write(XmlParser.marshal(Translate.convert(scoreList)).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
