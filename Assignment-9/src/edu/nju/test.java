package edu.nju;

import edu.nju.translate.Generator;
import edu.nju.translate.XmlParser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

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
    }

}
