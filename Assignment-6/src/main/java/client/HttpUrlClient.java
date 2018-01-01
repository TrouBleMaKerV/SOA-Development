package client;

import SCORE.Edit;

import javax.xml.soap.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUrlClient {

    public static void main(String[] args) {
        HttpUrlClient client = new HttpUrlClient();

        Edit editScore = new Edit("151250131", "25010350", "平时成绩", 45);
        System.out.println(client.doPost(editScore));
        client.writeToFile("<!--发送的信息SOAP封装：-->"+"\r\n");
        client.writeToFile(client.generatePostMsg(editScore));
        client.writeToFile("\r\n");
        client.writeToFile("<!--收到的信息SOAP封装：-->"+"\r\n");
        client.writeToFile(client.doPost(editScore));
        client.writeToFile("\r\n");


        editScore = new Edit("151250001", "25010350", "平时成绩", 80);
        System.out.println(client.doPost(editScore));
        client.writeToFile("<!--发送的信息SOAP封装：-->"+"\r\n");
        client.writeToFile(client.generatePostMsg(editScore));
        client.writeToFile("\r\n");
        client.writeToFile("<!--收到的信息SOAP封装：-->"+"\r\n");
        client.writeToFile(client.doPost(editScore));
        client.writeToFile("\r\n");

        editScore = new Edit("151250001", "", "平时成绩", 80);
        System.out.println(client.doPost(editScore));
        client.writeToFile("<!--发送的信息SOAP封装：-->"+"\r\n");
        client.writeToFile(client.generatePostMsg(editScore));
        client.writeToFile("\r\n");
        client.writeToFile("<!--收到的信息SOAP封装：-->"+"\r\n");
        client.writeToFile(client.doPost(editScore));
        client.writeToFile("\r\n");


    }

    private String doPost(Edit editScore) {
        try {
            URL url = new URL("http://localhost:8080/modify");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            String msg = generatePostMsg(editScore);
            PrintWriter printWriter = new PrintWriter(connection.getOutputStream());
            printWriter.write(msg);
            printWriter.flush();
            BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len;
            byte[] arr = new byte[1024];
            while ((len = bis.read(arr)) != -1) {
                bos.write(arr, 0, len);
                bos.flush();
            }
            bos.close();
            return bos.toString("utf-8");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String generatePostMsg(Edit entity) {
        try {
            MessageFactory messageFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
            SOAPMessage message = messageFactory.createMessage();
            SOAPPart soapPart = message.getSOAPPart();
            SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
            soapEnvelope.addNamespaceDeclaration("xsd", "http://www.w3.org/2001/XMLSchema");
            SOAPHeader soapHeader=soapEnvelope.getHeader();
            SOAPElement headelement = soapHeader.addChildElement(soapEnvelope.createName("transaction", "t", "http://www.w3school.com.cn/transaction/")).addTextNode("5");
            headelement.addAttribute(soapEnvelope.createQName("encodingStyle", "env"), "http://www.w3.org/2001/12/soap-encoding");
            headelement.addAttribute(soapEnvelope.createQName("mustUnderstand", "env"), "false");

            SOAPBody soapBody = soapEnvelope.getBody();
            SOAPElement element = soapBody.addChildElement(soapEnvelope.createName("课程成绩列表", "jw", "http://jw.nju.edu.cn/schema"));

            SOAPElement courseElement = element.addChildElement(element.createQName("课程成绩", "jw"));
            courseElement.addAttribute(element.createQName("成绩性质", "jw"),
                    entity.getCourseType());
            courseElement.addAttribute(element.createQName("课程编号", "jw"),
                    entity.getCid());
            SOAPElement scoreElement = courseElement.addChildElement(courseElement.createQName("成绩", "jw"));
            scoreElement.addChildElement(scoreElement.createQName("学号", "jw"))
                    .addTextNode(entity.getSid());
            scoreElement.addChildElement(scoreElement.createQName("得分", "jw"))
                    .addTextNode((entity.getScore()) + "");
            message.saveChanges();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            message.writeTo(stream);
            return new String(stream.toByteArray(), "utf-8");
        } catch (SOAPException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void writeToFile(String str) {
        try {
            FileOutputStream fos = new FileOutputStream("D:\\IDEAprojects\\Assignment-6\\src\\main\\result.xml", true);
//            FileOutputStream fos = new FileOutputStream(path, true);
            //true表示在文件末尾追加
            fos.write(str.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
