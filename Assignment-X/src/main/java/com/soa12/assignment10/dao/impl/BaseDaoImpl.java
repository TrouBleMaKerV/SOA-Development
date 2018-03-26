package com.soa12.assignment10.dao.impl;

import com.soa12.assignment10.dao.BaseDao;
import com.soa12.assignment10.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class BaseDaoImpl implements BaseDao {
    @Override
    public Object load(Class c, String id) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction tx=session.beginTransaction();
            Object o=session.get(c, id);
            tx.commit();
            return o;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object load(Class c, int id) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction tx=session.beginTransaction();
            Object o=session.get(c, id);
            tx.commit();
            return o;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Object> load(Class c, String name, String value) {
        try {
            Session session=HibernateUtil.getSession();
            Transaction tx=session.beginTransaction();
            Criteria criteria=session.createCriteria(c);
            criteria.add(Restrictions.eq(name,value));
            List<Object> res=criteria.list();
            return res;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Object> load(Class c, String name, int value) {
        try {
            Session session=HibernateUtil.getSession();
            Transaction tx=session.beginTransaction();
            Criteria criteria=session.createCriteria(c);
            criteria.add(Restrictions.eq(name,value));
            List<Object> res=criteria.list();
            return res;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List getAllList(Class c, String id) {
        return null;
    }

    @Override
    public void save(Object bean) {
        try {
            System.out.println("ready to getsession");
            Session session = HibernateUtil.getSession() ;
            Transaction tx=session.beginTransaction();
            session.merge(bean);
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Object bean) {
        try {
            System.out.println("ready to getsession");
            Session session =HibernateUtil.getSession() ;
            Transaction tx=session.beginTransaction();
            session.update(bean);
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Object bean) {
        try {
            System.out.println("ready to getsession");
            Session session =HibernateUtil.getSession() ;
            Transaction tx=session.beginTransaction();
            session.delete(bean);
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

