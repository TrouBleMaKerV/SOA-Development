package com.soa12.assignment10.dao.impl;

import com.soa12.assignment10.dao.ScoreDao;
import com.soa12.assignment10.model.ScoreEntity;
import com.soa12.assignment10.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/26.
 */

@Repository
public class ScoreDaoImpl extends BaseDaoImpl implements ScoreDao {

    @Override
    public void save(ScoreEntity scoreEntity) {
        try {
            Session session = HibernateUtil.getSession() ;
            Transaction tx=session.beginTransaction();
            session.saveOrUpdate(scoreEntity);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(ScoreEntity scoreEntity) {
        try {
            Session session = HibernateUtil.getSession() ;
            Transaction tx=session.beginTransaction();
            session.remove(scoreEntity);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ScoreEntity> findBySid(String sid) {
        ArrayList<ScoreEntity> scoreEntities=new ArrayList<>();
        try {
            Session session = HibernateUtil.getSession() ;
            Transaction tx=session.beginTransaction();

            String hql = "from com.soa12.assignment10.model.ScoreEntity u where u.sid = :si";
            Query query = session.createQuery(hql);
            query.setString("si",sid);
            scoreEntities =(ArrayList<ScoreEntity>) query.list();
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return scoreEntities;

    }

    @Override
    public void update(ScoreEntity scoreEntity) {
        super.update(scoreEntity);
    }
}
