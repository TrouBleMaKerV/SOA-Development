package com.soa12.assignment10.model;

import com.soa12.assignment10.schemaModel.ScoreType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "score", schema = "soa", catalog = "")
public class ScoreEntity implements Serializable {
    private String cid;
    private ScoreType scoreType;
    private String sid;
    private int score;

    public ScoreEntity(String cid, ScoreType scoreType, String sid, int score) {
        this.cid = cid;
        this.scoreType = scoreType;
        this.sid = sid;
        this.score = score;
    }

    public ScoreEntity() {
    }

    @Id
    @Column(name = "cid", nullable = false)
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "scoreType", nullable = false)
    public ScoreType getScoreType() {
        return scoreType;
    }

    public void setScoreType(ScoreType scoreType) {
        this.scoreType = scoreType;
    }

    @Id
    @Column(name = "sid", nullable = false)
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "score", nullable = false)
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

