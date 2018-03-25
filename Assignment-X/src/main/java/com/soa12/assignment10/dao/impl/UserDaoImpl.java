package com.soa12.assignment10.dao.impl;

import com.soa12.assignment10.dao.UserDao;
import com.soa12.assignment10.model.UsersEntity;
import com.soa12.assignment10.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {
    @Override
    public UsersEntity getUser(String email) {
        ArrayList<UsersEntity > users=new ArrayList<>();
        try {
            Session session = HibernateUtil.getSession() ;
            Transaction tx=session.beginTransaction();

            String hql = "from com.soa12.assignment10.model.UsersEntity u where u.email= :e";
            Query query = session.createQuery(hql);
            query.setString("e",email);
            users =(ArrayList<UsersEntity>) query.list();
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        if (users==null){
            return null;
        }else {
            return users.get(0);
        }
    }

    @Override
    public void save(UsersEntity user) {
        super.save(user);
    }

    @Override
    public void update(UsersEntity user) {
        super.update(user);
    }
}
