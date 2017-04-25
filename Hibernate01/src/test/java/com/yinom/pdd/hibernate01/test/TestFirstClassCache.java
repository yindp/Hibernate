package com.yinom.pdd.hibernate01.test;

import com.yinom.pdd.hibernate01.bean.Employee;
import com.yinom.pdd.hibernate01.util.MySessionFactory;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by yindp on 4/24/17.
 */
public class TestFirstClassCache {
    @Test
    public void test() {
        Session session = null;
        try {
            session = MySessionFactory.openSession();
            Employee em1 = session.get(Employee.class, "ff8080815b997d49015b997d4a850002");
            System.out.println(em1);
            Employee em2 = session.get(Employee.class, "ff8080815b997d49015b997d4a850002");
            System.out.println(em2);
            Employee em3 = session.get(Employee.class, "ff8080815b99807f015b9980805a0002");
            System.out.println(em3);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MySessionFactory.close(session);
        }

    }
}
