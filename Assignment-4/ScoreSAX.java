import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class ScoreSAX extends DefaultHandler{

    private CourseList courseList;
    private ArrayList<CourseList> courseLists;
    private ArrayList<CourseList> failLists;
    private ScoreItem scoreItem;
    private String currentTag;

    public List<CourseList> getCourseList(){
        return courseLists;
    }

    public List<CourseList> getFailLists() {
        return failLists;
    }

    @Override
    public void startDocument() throws SAXException {

        courseLists=new ArrayList<CourseList>();
        failLists=new ArrayList<CourseList>();
//        lessons = new ArrayList<BillList>();
//        billItems= new ArrayList<BillItem>();
    }
    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if(courseList != null){
            String data=new String(ch,start,length);
            if("学号".equals(currentTag)){
                scoreItem.setStudent_id(data);
            }
            if("得分".equals(currentTag)){
                scoreItem.setScore(Integer.parseInt(data));
            }
            if("课程名称".equals(currentTag)){
                courseList.setCourse_name(data);
            }
            if("课程编号".equals(currentTag)){
                courseList.setCourse_id(data);
            }
            if("成绩性质".equals(currentTag)){
                courseList.setScore_type(data);
            }
        }
    }

    @Override
    public void startElement(String uri, String localName, String name,
                             Attributes attr) throws SAXException {
        if ("课程成绩".equals(name)){
            courseList=new CourseList();
        }
        if("成绩".equals(name)){
            scoreItem=new ScoreItem();
        }
        currentTag = name;

    }

    @Override
    public void endElement(String uri, String localName, String name)
            throws SAXException {
        if (courseList!=null && "课程成绩".equals(name)){
            courseList.setScoreItem(scoreItem);
            courseLists.add(courseList);
            String courser_id=courseList.getCourse_id();
            String student_id=scoreItem.getStudent_id();
            for(int i=0;i<failLists.size();i++){
                if(failLists.get(i).getScoreItem().getStudent_id().equals(student_id) && failLists.get(i).getCourse_id().equals(courser_id)){
                    if(!failLists.contains(courseLists.get(i))){
                        failLists.add(courseLists.get(i));
                    }
                    else{

                    }
                }
            }
            if(scoreItem.getScore()<60){
                for(int i=0;i<courseLists.size();i++){
                    if(courseLists.get(i).getScoreItem().getStudent_id().equals(student_id) && courseLists.get(i).getCourse_id().equals(courser_id)){
                        if(!failLists.contains(courseLists.get(i))){
                            failLists.add(courseLists.get(i));
                        }
                        else{

                        }
                    }
                }
            }
            courseList=null;
            scoreItem=null;
        }
        if(scoreItem!=null && "成绩".equals(name)){

        }

        currentTag = null;
    }

}
