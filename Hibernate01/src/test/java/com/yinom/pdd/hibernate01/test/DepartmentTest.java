package com.yinom.pdd.hibernate01.test;

import com.yinom.pdd.hibernate01.bean.Department;
import com.yinom.pdd.hibernate01.util.MySessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by yindp on 4/22/17.
 */
public class DepartmentTest {
    @Test
    public void testAssigned() {
        Session session = null;
        try {
            session = MySessionFactory.openSession();
            session.beginTransaction();
            Department department = new Department();
            department.setName("Finance");
            session.save(department);
            session.getTransaction().commit();
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
