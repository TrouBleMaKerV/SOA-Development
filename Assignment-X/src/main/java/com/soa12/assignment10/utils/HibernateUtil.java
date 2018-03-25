package com.soa12.assignment10.utils;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        try {
            Configuration config;
            config = new Configuration();

            sessionFactory = config.configure().buildSessionFactory();
            return sessionFactory;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * gerCurrentSession ���Զ��ر�session��ʹ�õ��ǵ�ǰ��session���� * * @return
     */
    public static Session getSession() {
        return getSessionFactory().getCurrentSession();
    }
}
