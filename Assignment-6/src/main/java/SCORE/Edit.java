package SCORE;

public class Edit {
    private String  sid;
    private String  cid;
    private String courseType;
    private int score;

    public Edit(){

    }

    public Edit(String  sid, String  cid, String courseType, int score){
        this.sid = sid;
        this.cid = cid;
        this.courseType = courseType;
        this.score = score;
    }

    @Override
    public String toString() {
        return "EditScore{" +
                "sid=" + sid +
                ", cid=" + cid +
                ", courseType='" + courseType + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edit editScore = (Edit) o;

        if (sid != editScore.sid) return false;
        if (cid != editScore.cid) return false;
        if (score != editScore.score) return false;
        return courseType != null ? courseType.equals(editScore.courseType) : editScore.courseType == null;
    }
//
//    @Override
//    public int hashCode() {
//        int result = sid;
//        result = 31 * result + cid;
//        result = 31 * result + (courseType != null ? courseType.hashCode() : 0);
//        result = 31 * result + score;
//        return result;
//    }

    public String  getSid() {
        return sid;
    }

    public void setSid(String  sid) {
        this.sid = sid;
    }

    public String  getCid() {
        return cid;
    }

    public void setCid(String  cid) {
        this.cid = cid;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
