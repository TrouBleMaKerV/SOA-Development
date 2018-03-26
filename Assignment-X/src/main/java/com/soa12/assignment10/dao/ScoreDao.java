package com.soa12.assignment10.dao;

import com.soa12.assignment10.model.ScoreEntity;

import java.util.List;

/**
 * Created by Administrator on 2018/3/26.
 */
public interface ScoreDao {

    void save(ScoreEntity scoreEntity);
    void delete(ScoreEntity scoreEntity);
    List<ScoreEntity> findBySid(String sid);
}
