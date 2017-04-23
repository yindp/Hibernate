package com.yinom.pdd.hibernate01.test;

import com.yinom.pdd.hibernate01.bean.Department;
import com.yinom.pdd.hibernate01.util.MySessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by yindp on 4/22/17.
 */
public class TestStatus {
    @Test
    public void test() {
        Department department = new Department();//The entity is transient at this moment.
        department.setName("Finance");
        Session session = null;
        try {
            session = MySessionFactory.openSession();
            session.beginTransaction();

            session.save(department);//The entity is persistent at this moment.
            session.getTransaction().commit();
            department.setName("Test");//The entity is detached at this moment.
        } catch (HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
                e.printStackTrace();
            }
        } finally {
            MySessionFactory.close(session);
        }

    }
}
