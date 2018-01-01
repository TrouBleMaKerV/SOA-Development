package SCORE;

public class Score {
    public  String cid;
    public  String sid;
    public  int score;
    public  String type;
    public  String cname;

    public void setScore(int score) {
        this.score = score;
    }

    public  int getScore() {
        return score;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public  String  getType() {
        return type;
    }

    public  void setType(String type) {
        this.type = type;
    }

    public String getCid() {
        return cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
