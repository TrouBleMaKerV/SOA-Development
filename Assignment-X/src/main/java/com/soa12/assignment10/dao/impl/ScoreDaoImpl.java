package com.soa12.assignment10.dao.impl;

import com.soa12.assignment10.dao.ScoreDao;
import com.soa12.assignment10.model.ScoreEntity;
import com.soa12.assignment10.model.UsersEntity;
import com.soa12.assignment10.utils.HibernateUtil;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/26.
 */
public class ScoreDaoImpl extends BaseDaoImpl implements ScoreDao {
    @Override
    public void save(ScoreEntity scoreEntity) {
        super.save(scoreEntity);
    }

    @Override
    public void delete(ScoreEntity scoreEntity) {
        super.delete(scoreEntity);
    }

    @Override
    public List<ScoreEntity> findBySid(String sid) {
        ArrayList<ScoreEntity> scoreEntities=new ArrayList<>();
        try {
            Session session = HibernateUtil.getSession() ;
            Transaction tx=session.beginTransaction();

            String hql = "from com.soa12.assignment10.model.ScoreEntity u where u.id= :e";
            Query query = session.createQuery(hql);
            query.setString("e",sid);
            scoreEntities =(ArrayList<ScoreEntity>) query.list();
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        if (scoreEntities==null){
            return null;
        }else {
            return scoreEntities.get(0);
        }
    }
}
