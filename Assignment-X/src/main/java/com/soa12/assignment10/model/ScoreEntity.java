package com.soa12.assignment10.model;

import com.soa12.assignment10.schemaModel.ScoreType;

/**
 * Created by Administrator on 2018/3/26.
 */

@Entity
@Table(name = "score", schema = "soa", catalog = "")
public class ScoreEntity {
    private String cid;
    private ScoreType scoreType;
    private String sid;
    private int score;

    @Id
    @Column(name = "cid", nullable = false, length = 6)
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
    @Column(name = "sid", nullable = false, length = 9)
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
