package com.yinom.pdd.hibernate01.util;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Map;

/**
 * Created by yindp on 4/24/17.
 */
public class HibernateUtil {
    /**
     * Common query method
     *
     * @param hql
     * @param params
     * @return
     */
    public static List executeQuery(String hql, String[] params) {
        List list = null;
        Session session = null;
        try {
            session = MySessionFactory.openSession();
            Query query = session.createQuery(hql);
            if (params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    query.setString(i, params[i]);
                }
            }
            list = query.list();
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            MySessionFactory.close(session);
        }
        return list;
    }

    public static List executeQuery(String hql, Map<String, String> params) {
        List list = null;
        Session session = null;
        try {
            session = MySessionFactory.openSession();
            Query query = session.createQuery(hql);
            if (params != null && params.size() > 0) {
                for (String key : params.keySet()) {
                    query.setString(key, params.get(key));
                }
            }
            list = query.list();
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            MySessionFactory.close(session);
        }
        return list;
    }

    public static List executeQuery(String hql, Map<String, String> params,int pageSize,int pageNum) {
        List list = null;
        Session session = null;
        try {
            session = MySessionFactory.openSession();
            Query query = session.createQuery(hql);
            if (params != null && params.size() > 0) {
                for (String key : params.keySet()) {
                    query.setString(key, params.get(key));
                }
            }
            query.setFirstResult((pageNum - 1) * pageSize);
            query.setMaxResults(pageSize);
            list = query.list();
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            MySessionFactory.close(session);
        }
        return list;
    }
}
