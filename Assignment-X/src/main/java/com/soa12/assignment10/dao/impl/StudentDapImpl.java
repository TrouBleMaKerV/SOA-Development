package com.soa12.assignment10.dao.impl;

import com.soa12.assignment10.dao.StudentDao;
import com.soa12.assignment10.model.StudentEntity;
import com.soa12.assignment10.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class StudentDapImpl extends BaseDaoImpl implements StudentDao {
    @Override
    public StudentEntity getStudent(String studentId) {
        ArrayList<StudentEntity > users=new ArrayList<>();
        try {
            Session session = HibernateUtil.getSession() ;
            Transaction tx=session.beginTransaction();

            String hql = "from com.soa12.assignment10.model.StudentEntity u where u.studentId= :e";
            Query query = session.createQuery(hql);
            query.setString("e",studentId);
            users =(ArrayList<StudentEntity>) query.list();
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
    public void save(StudentEntity user) {
        super.save(user);
    }

    @Override
    public void update(StudentEntity user) {
        super.update(user);
    }

    @Override
    public void delete(StudentEntity student) {
        try {
            System.out.println("ready to getsession");
            Session session =HibernateUtil.getSession() ;
            Transaction tx=session.beginTransaction();
            session.remove(student);
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
