package com.soa12.assignment10.model;

import com.soa12.assignment10.schemaModel.ScoreType;

import javax.persistence.*;
import java.time.format.SignStyle;

@Entity
@Table(name = "score", schema = "soa", catalog = "")
public class ScoreEntity {
    private int recordid;
    private String cid;
    private String scoreType;
    //    private ScoreType scoreType;
    private String sid;
    private Integer score;

    @Id
    @Column(name = "recordid")
    public int getRecordid() {
        return recordid;
    }

    public void setRecordid(int recordid) {
        this.recordid = recordid;
    }

    @Basic
    @Column(name = "cid")
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Basic
    @Column(name = "scoreType")
    public String getScoreType() {
        return scoreType;
    }

    public void setScoreType(String scoreType) {
        this.scoreType = scoreType;
    }
//    public ScoreType getScoreType() {
//        return scoreType;
//    }
//
//    public void setScoreType(ScoreType scoreType) {
//        this.scoreType = scoreType;
//    }

    @Basic
    @Column(name = "sid")
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "score")
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScoreEntity that = (ScoreEntity) o;

        if (recordid != that.recordid) return false;
        if (cid != null ? !cid.equals(that.cid) : that.cid != null) return false;
//        if (scoreType != null ? !scoreType.equals(that.scoreType) : that.scoreType != null) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (score != null ? !score.equals(that.score) : that.score != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recordid;
        result = 31 * result + (cid != null ? cid.hashCode() : 0);
//        result = 31 * result + (scoreType != null ? scoreType.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        return result;
    }
}
