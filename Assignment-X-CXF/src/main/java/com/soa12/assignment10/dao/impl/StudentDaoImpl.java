package com.soa12.assignment10.dao.impl;

import com.soa12.assignment10.dao.StudentDao;
import com.soa12.assignment10.model.StudentsEntity;
import com.soa12.assignment10.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class StudentDaoImpl extends BaseDaoImpl implements StudentDao {
    private static StudentDaoImpl studentDao = new StudentDaoImpl();
    private StudentDaoImpl(){

    }
    public static StudentDaoImpl getInstance(){
        return studentDao;
    }
    @Override
    public StudentsEntity getStudent(int studentId) {
        ArrayList<StudentsEntity > users=new ArrayList<>();
        try {
            Session session = HibernateUtil.getSession() ;
            Transaction tx=session.beginTransaction();

            String hql = "from com.soa12.assignment10.model.StudentsEntity u where u.id = :e";
            Query query = session.createQuery(hql);
            query.setInteger("e",studentId);
            users =(ArrayList<StudentsEntity>) query.list();
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        if (users==null|| users.size()==0){
            return null;
        }else {
            return users.get(0);
        }
    }

    @Override
    public void save(StudentsEntity user) {
        super.save(user);
    }

    @Override
    public void update(StudentsEntity user) {
        super.update(user);
    }

    @Override
    public void delete(StudentsEntity student) {
        try {
            System.out.println("ready to getsession");
            Session session = HibernateUtil.getSession() ;
            Transaction tx=session.beginTransaction();
            session.remove(student);
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
