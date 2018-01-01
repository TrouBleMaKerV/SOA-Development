package Controller;

import Dao.ScoreDao;
import SCORE.Edit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.soap.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@WebServlet("/modify")
public class ScoreServlet extends HttpServlet {

    private ScoreDao scoreDao;
    private MessageFactory messageFactory;

    @Override
    public void init() throws ServletException {
        scoreDao = new ScoreDao();
        try {
            messageFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        } catch (SOAPException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        MimeHeaders headers = new MimeHeaders();
        Edit editScore = new Edit();
        try {
            InputStream inputStream = request.getInputStream();
            SOAPMessage message = messageFactory.createMessage(headers, inputStream);
            SOAPBody soapBody = message.getSOAPBody();
            Iterator iterator = soapBody.getChildElements();
            SOAPElement element = (SOAPElement) iterator.next();
            Iterator dataIterator = element.getChildElements();
            if (dataIterator.hasNext()) {
                SOAPElement soapElement = (SOAPElement) dataIterator.next();
                String courseType = soapElement.getAttribute("jw:成绩性质");
                String cid = soapElement.getAttribute("jw:课程编号");
                SOAPElement scoreElement = (SOAPElement) soapElement.getChildElements().next();
                String sid = scoreElement.getFirstChild().getTextContent();
                String score = scoreElement.getLastChild().getTextContent();
                if(courseType.equals("")||cid.equals("")||sid.equals("")||score==null){
                    generateFault(response, "成绩性质，课程编号，学号，得分都不可以为空::成绩性质:"+courseType+";课程编号:"+cid+";学号:"+sid+";得分:"+score+";");
                    return;
                }
                else{
                    editScore = new Edit((sid), (cid), courseType, Integer.parseInt(score));
                }
            } else {
                generateFault(response, "没有获取到需要的信息");
                return;
            }
            String msg = scoreDao.modifyScore(editScore);
            if (!msg.equals("")) {
                generateFault(response, msg);
                return;
            }

            generateMsg(response, message);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SOAPException e) {
            e.printStackTrace();
        }
    }

    private void generateFault(HttpServletResponse response, String msg) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type", "text/xml;charset=UTF-8");
        PrintWriter writer;
        try {
            response.setStatus(HttpServletResponse.SC_OK);
            writer = response.getWriter();
            writer.print(generateFaultMsg(msg));
        } catch (IOException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
    }

    private void generateMsg(HttpServletResponse response, SOAPMessage message) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type", "text/xml;charset=UTF-8");
        PrintWriter writer;
        try {
            SOAPPart soapPart = message.getSOAPPart();
            SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
            soapEnvelope.addNamespaceDeclaration("xsd", "http://www.w3.org/2001/XMLSchema");
            soapEnvelope.addNamespaceDeclaration("my", "http://www.example.com/");
            //header
//            SOAPHeader soapHeader = soapEnvelope.getHeader();
//            SOAPElement headelement = soapHeader.addChildElement(soapEnvelope.createName("transaction", "t", "http://www.w3school.com.cn/transaction/")).addTextNode("5");
//            headelement.addAttribute(soapEnvelope.createQName("encodingStyle", "env"), "http://www.w3.org/2001/12/soap-encoding");
//            headelement.addAttribute(soapEnvelope.createQName("mustUnderstand", "env"), "false");


            response.setStatus(HttpServletResponse.SC_OK);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            message.writeTo(stream);
            String result = new String(stream.toByteArray(), "utf-8");
            writer = response.getWriter();
            writer.print(result);
        } catch (IOException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        } catch (SOAPException e) {
            e.printStackTrace();
        }
    }


    private String generateFaultMsg(String msg) {
        try {
            SOAPMessage message = messageFactory.createMessage();
            SOAPPart soapPart = message.getSOAPPart();
            SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
            soapEnvelope.addNamespaceDeclaration("xsd", "http://www.w3.org/2001/XMLSchema");
            soapEnvelope.addNamespaceDeclaration("my", "http://www.example.com/");
            //header
            SOAPHeader soapHeader = soapEnvelope.getHeader();
            SOAPElement headelement = soapHeader.addChildElement(soapEnvelope.createName("transaction", "t", "http://www.w3school.com.cn/transaction/")).addTextNode("5");
            headelement.addAttribute(soapEnvelope.createQName("encodingStyle", "env"), "http://www.w3.org/2001/12/soap-encoding");
            headelement.addAttribute(soapEnvelope.createQName("mustUnderstand", "env"), "false");

            SOAPBody soapBody = soapEnvelope.getBody();
            SOAPFault fault = soapBody.addFault();
            fault.setFaultCode("env:Receiver");
            QName subcode = soapEnvelope.createQName("bad argument", "my");
            fault.appendFaultSubcode(subcode);
            fault.addFaultReasonText("NULLException:" + msg, Locale.CHINESE);
            Detail detail = fault.addDetail();
            detail.addChildElement(soapEnvelope.createQName("cause", "my")).addTextNode("请确认输入的学号和课程编号存在");
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


}
