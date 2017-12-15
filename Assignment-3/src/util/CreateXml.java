package util;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

//import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateXml {
	
	public static void createXml(File file){
		
		//创建DocumentBuilderFactory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
            // 创建DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // 创建Document
            Document document = builder.newDocument();

            // 创建根节点
            Element studentList = document.createElement("学生列表");
            

            //学生1信息
            String s_id1 = "151250004";
            String s_name1 = "蔡赵辰";
            String s_department1 = "软件工程";
            String s_domitory1 = "南园6舍";
			String s_card1 = "410425199701010038";
			String s_type1 = "本科生";
			
			String [][] score1 = { {"80", "90", "87"},
								  {"63", "82", "76"},
								  {"80", "85", "83"},
								  {"89", "94", "90"},
								  {"70", "61", "67"} };
			
            //学生2信息
            String s_id2 = "151250089";
            String s_name2 = "李珍鸿";
            String s_department2 = "软件工程";
            String s_domitory2 = "南园6舍";
			String s_card2 = "410425199701010039";
			String s_type2 = "本科生";
			
			String [][] score2 = { {"89", "80", "85"},
								  {"80", "80", "80"},
								  {"93", "80", "88"},
								  {"67", "80", "74"},
								  {"70", "55", "58"} };
			
            //学生3信息
            String s_id3 = "151250099";
            String s_name3 = "刘一澎";
            String s_department3 = "软件工程";
            String s_domitory3 = "南园6舍";
			String s_card3 = "410425199701010037";
			String s_type3 = "本科生";
			
			String [][] score3 = { {"80", "85", "84"},
								  {"90", "80", "85"},
								  {"50", "63", "59"},
								  {"82", "89", "86"},
								  {"93", "80", "88"} };
			
            //学生4信息
            String s_id4 = "151250135";
            String s_name4 = "万年杰";
            String s_department4 = "软件工程";
            String s_domitory4 = "南园6舍";
			String s_card4 = "410425199701010040";
			String s_type4 = "本科生";
			
			String [][] score4 = { {"89", "80", "85"},
								  {"63", "82", "76"},
								  {"60", "74", "69"},
								  {"93", "80", "88"},
								  {"80", "80", "80"} };
			
            //学生5信息
            String s_id5 = "151250088";
            String s_name5 = "李雨倩";
            String s_department5 = "软件工程";
            String s_domitory5 = "陶园1舍";
			String s_card5 = "320714199701010088";
			String s_type5 = "本科生";
			
			String [][] score5 = { {"70", "55", "59"},
								  {"73", "86", "79"},
								  {"89", "95", "93"},
								  {"93", "82", "88"},
								  {"80", "80", "80"} };
			
            //学生6信息
            String s_id6 = "151250171";
            String s_name6 = "徐佳炜";
            String s_department6 = "软件工程";
            String s_domitory6 = "南园6舍";
			String s_card6 = "320714199701010171";
			String s_type6 = "本科生";
			
			String [][] score6 = { {"89", "80", "80"},
								  {"90", "80", "85"},
								  {"77", "80", "79"},
								  {"86", "93", "89"},
								  {"63", "82", "76"} };
			
            //学生7信息
            String s_id7 = "151250174";
            String s_name7 = "徐杨晨";
            String s_department7 = "软件工程";
            String s_domitory7 = "南园6舍";
			String s_card7 = "320714199701010174";
			String s_type7 = "本科生";
			
			String [][] score7 = { {"73", "86", "79"},
								  {"80", "80", "80"},
								  {"70", "55", "58"},
								  {"73", "86", "79"},
								  {"73", "92", "86"} };
			
            //学生8信息
            String s_id8 = "151250188";
            String s_name8 = "袁颜颜";
            String s_department8 = "软件工程";
            String s_domitory8 = "陶园1舍";
			String s_card8 = "320714199701010188";
			String s_type8 = "本科生";
			
			String [][] score8 = { {"77", "80", "79"},
								  {"77", "80", "79"},
								  {"90", "92", "91"},
								  {"93", "80", "88"},
								  {"93", "96", "95"} };
			
            //学生9信息
            String s_id9 = "151250011";
            String s_name9 = "常德龙";
            String s_department9 = "软件工程";
            String s_domitory9 = "南园6舍";
			String s_card9 = "410425199701010011";
			String s_type9 = "本科生";
			
			String [][] score9 = { {"86", "93", "89"},
								  {"72", "80", "74"},
								  {"89", "80", "85"},
								  {"61", "72", "69"},
								  {"63", "82", "76"} };
			
            //学生10信息
            String s_id10 = "151250131";
            String s_name10 = "唐骞";
            String s_department10 = "软件工程";
            String s_domitory10 = "南园6舍";
			String s_card10 = "410425199701010131";
			String s_type10 = "本科生";
			
			String [][] score10 = { {"80", "77", "75"},
								  {"63", "82", "76"},
								  {"80", "80", "80"},
								  {"40", "61", "53"},
								  {"89", "72", "89"} };
			
            //学生11信息
            String s_id11 = "151250006";
            String s_name11 = "曹洪荣";
            String s_department11 = "软件工程";
            String s_domitory11 = "南园6舍";
			String s_card11 = "410425199701010006";
			String s_type11 = "本科生";
			
			String [][] score11 = { {"73", "86", "79"},
								  {"93", "80", "88"},
								  {"71", "54", "60"},
								  {"73", "86", "79"},
								  {"61", "72", "69"} };
			
            //学生12信息
            String s_id12 = "151250065";
            String s_name12 = "黄韵斐";
            String s_department12 = "软件工程";
            String s_domitory12 = "南园6舍";
			String s_card12 = "410425199701010065";
			String s_type12 = "本科生";
			
			String [][] score12 = { {"63", "82", "76"},
								  {"63", "82", "76"},
								  {"80", "80", "80"},
								  {"73", "86", "79"},
								  {"84", "72", "80"} };
			
			String [] score_type = {"平时成绩","期末成绩","总评成绩"};		
			String [] course_type_id = { "25010390", "25010110", "25010570", "25010350", "25010240"};
			String [] course_type_name = { "Linux程序设计", "软件系统设计与体系结构", "服务计算与SOA开发", "J2EE与中间件", "软件需求"};
			

            // 创建学生1子节点
            Element student1 = createStudent(document, s_id1, s_name1, s_department1, s_domitory1, s_card1,
            		s_type1, score1, score_type, course_type_id, course_type_name);
            
            // 创建学生2子节点
            Element student2 = createStudent(document, s_id2, s_name2, s_department2, s_domitory2, s_card2,
            		s_type2, score2, score_type, course_type_id, course_type_name);
            
            // 创建学生1子节点
            Element student3 = createStudent(document, s_id3, s_name3, s_department3, s_domitory3, s_card3,
            		s_type3, score3, score_type, course_type_id, course_type_name);
            
            // 创建学生4子节点
            Element student4 = createStudent(document, s_id4, s_name4, s_department4, s_domitory4, s_card4,
            		s_type4, score4, score_type, course_type_id, course_type_name);
            
            // 创建学生5子节点
            Element student5 = createStudent(document, s_id5, s_name5, s_department5, s_domitory5, s_card5,
            		s_type5, score5, score_type, course_type_id, course_type_name);
            
            // 创建学生6子节点
            Element student6 = createStudent(document, s_id6, s_name6, s_department6, s_domitory6, s_card6,
            		s_type6, score6, score_type, course_type_id, course_type_name);
            
            // 创建学生7子节点
            Element student7 = createStudent(document, s_id7, s_name7, s_department7, s_domitory7, s_card7,
            		s_type7, score7, score_type, course_type_id, course_type_name);
            
            // 创建学生8子节点
            Element student8 = createStudent(document, s_id8, s_name8, s_department8, s_domitory8, s_card8,
            		s_type8, score8, score_type, course_type_id, course_type_name);
            
            // 创建学生9子节点
            Element student9 = createStudent(document, s_id9, s_name9, s_department9, s_domitory9, s_card9,
            		s_type9, score9, score_type, course_type_id, course_type_name);
            
            // 创建学生10子节点
            Element student10 = createStudent(document, s_id10, s_name10, s_department10, s_domitory10, s_card10,
            		s_type10, score10, score_type, course_type_id, course_type_name);
            
            // 创建学生1子节点
            Element student11 = createStudent(document, s_id11, s_name11, s_department11, s_domitory11, s_card11,
            		s_type11, score11, score_type, course_type_id, course_type_name);
            
            // 创建学生12子节点
            Element student12 = createStudent(document, s_id12, s_name12, s_department12, s_domitory12, s_card12,
            		s_type12, score12, score_type, course_type_id, course_type_name);
            
            // 为根节点添加子节点
            studentList.appendChild(student1);
            studentList.appendChild(student2);
            studentList.appendChild(student3);
            studentList.appendChild(student4);
            studentList.appendChild(student5);
            studentList.appendChild(student6);
            studentList.appendChild(student7);
            studentList.appendChild(student8);
            studentList.appendChild(student9);
            studentList.appendChild(student10);
            studentList.appendChild(student11);
            studentList.appendChild(student12);
            
            // 将根节点添加到Document下
            document.appendChild(studentList);
            
            // 创建TransformerFactory对象
            TransformerFactory tff = TransformerFactory.newInstance();

            
            // 创建Transformer对象
            Transformer tf = tff.newTransformer();

            
            //设置输出数据时换行
            tf.setOutputProperty(OutputKeys.INDENT, "yes");

            // 使用Transformer的transform()方法将DOM树转换成XML
            tf.transform(new DOMSource(document), new StreamResult(file));
            
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	//创建学生节点
	private static Element createStudent(Document document, String s_id, String s_name, String s_department, String s_domitory,
			String s_card, String s_type, String [][] score, String [] score_type, String [] course_type_id, String [] course_type_name){
		
		Element student = document.createElement("学生");
		Element basicInfo = createBasicInfo(document, s_id, s_name, s_department, s_domitory,
				 s_card, s_type);
       
		Element CourseList = createCourseList(document);
		
       //创建子节点ScoreList，并为ScoreList添加子节点
       Element ScoreList = document.createElement("课程成绩列表");
       for(int i = 0; i < 5; i++){
       	for(int j = 0; j < 3; j++){
       		Element courseScore = createCourseScore(document, s_id, score[i][j], course_type_id[i], course_type_name[i], score_type[j]);
       		ScoreList.appendChild(courseScore);
       	}
       }          
       
       student.appendChild(basicInfo);
       student.appendChild(CourseList);
       student.appendChild(ScoreList);
       return student;
	}

	//创建学生基本信息节点
	private static Element createBasicInfo(Document document, String s_id, String s_name, String s_department, String s_domitory,
			String s_card, String s_type){
        
        
        //创建子节点basicInfo，并为basicInfo添加子节点
        Element basicInfo = document.createElement("学生基本信息");
        
        Element id = document.createElement("学号");
        Element name = document.createElement("姓名");
        Element department = document.createElement("学院");
        Element dormitory = document.createElement("宿舍");
        Element card = document.createElement("身份证");
        Element type = document.createElement("学生类型");
        
        id.setTextContent(s_id);
        name.setTextContent(s_name);
        department.setTextContent(s_department);
        dormitory.setTextContent(s_domitory);
        card.setTextContent(s_card);
        type.setTextContent(s_type);
        
        basicInfo.appendChild(id);
        basicInfo.appendChild(name);
        basicInfo.appendChild(department);
        basicInfo.appendChild(dormitory);
        basicInfo.appendChild(card);
        basicInfo.appendChild(type);
		
        return basicInfo;
		
	}
	
	//创建课程列表节点
	private static Element createCourseList(Document document){
        //创建子节点CourseList，并为CourseList添加子节点
        Element CourseList = document.createElement("课程列表");
        
        Element courseId1 = document.createElement("课程编号");
        Element courseName1 = document.createElement("课程名称");
        
        Element courseId2 = document.createElement("课程编号");
        Element courseName2 = document.createElement("课程名称");
        
        Element courseId3 = document.createElement("课程编号");
        Element courseName3 = document.createElement("课程名称");
        
        Element courseId4 = document.createElement("课程编号");
        Element courseName4 = document.createElement("课程名称");
        
        Element courseId5 = document.createElement("课程编号");
        Element courseName5 = document.createElement("课程名称");
        
        courseId1.setTextContent("25010390");
        courseName1.setTextContent("Linux程序设计");
        
        courseId2.setTextContent("25010110");
        courseName2.setTextContent("软件系统设计与体系结构");
        
        courseId3.setTextContent("25010570");
        courseName3.setTextContent("服务计算与SOA开发");
        
        courseId4.setTextContent("25010350");
        courseName4.setTextContent("J2EE与中间件");
        
        courseId5.setTextContent("25010240");
        courseName5.setTextContent("软件需求");
        
        CourseList.appendChild(courseId1);
        CourseList.appendChild(courseName1);
        
        CourseList.appendChild(courseId2);
        CourseList.appendChild(courseName2);
        
        CourseList.appendChild(courseId3);
        CourseList.appendChild(courseName3);
        
        CourseList.appendChild(courseId4);
        CourseList.appendChild(courseName4);
        
        CourseList.appendChild(courseId5);
        CourseList.appendChild(courseName5);
        
        return CourseList;
	}
	
	//创建课程成绩节点
	private static Element createCourseScore(Document document, String s_id, String s_score, String c_id, String c_name, String s_type){
        //创建子节点courseScore，并为courseScore添加子节点
        Element courseScore = document.createElement("课程成绩");
        
        //创建子节点score，并为score添加子节点
        Element score = document.createElement("成绩");
        Element CourseName = document.createElement("课程名称");
        Element CourseID = document.createElement("课程编号");
        Element scoreType = document.createElement("成绩性质");
        
        
        Element ID = document.createElement("学号");
        Element getScore = document.createElement("得分");
        
        ID.setTextContent(s_id);
        getScore.setTextContent(s_score);
        CourseName.setTextContent(c_name);
        CourseID.setTextContent(c_id);
        scoreType.setTextContent(s_type);
        
        
        courseScore.appendChild(score);
        courseScore.appendChild(CourseName);
        courseScore.appendChild(CourseID);
        courseScore.appendChild(scoreType);
        
        score.appendChild(ID);
        score.appendChild(getScore);
        return courseScore;
	}
	
	public static void main(String []args){
		File f1 = new File("XML文档2.xml");
		createXml(f1);
	}

}
