package com.yinom.pdd.hibernate01.test;

import com.yinom.pdd.hibernate01.bean.Department;
import com.yinom.pdd.hibernate01.bean.Employee;
import com.yinom.pdd.hibernate01.bean.IdCard;
import com.yinom.pdd.hibernate01.bean.Person;
import com.yinom.pdd.hibernate01.util.MySessionFactory;
import org.hibernate.Session;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yindp on 4/22/17.
 */
public class OneToOneTest {
    @Test
    public void test() {
        Session session = null;
        try {
            session = MySessionFactory.openSession();
            session.beginTransaction();

            Person p = new Person();
            p.setName("Miro");
            IdCard idCard = new IdCard();
            idCard.setNumber("91238741023");
            idCard.setPerson(p);
            session.save(idCard);
            session.save(p);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            MySessionFactory.close(session);
        }
    }
    @Test
    public void test02() {
        Session session = null;
        try {
            session = MySessionFactory.openSession();
            session.beginTransaction();

            Person p = new Person();
            p.setName("Ana");
            IdCard idCard = new IdCard();
            idCard.setNumber("923891290");
            idCard.setPerson(p);
            session.save(idCard);
            session.save(p);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            MySessionFactory.close(session);
        }
    }
}
