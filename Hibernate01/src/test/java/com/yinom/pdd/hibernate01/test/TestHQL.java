package com.yinom.pdd.hibernate01.test;

import com.yinom.pdd.hibernate01.bean.Employee;
import com.yinom.pdd.hibernate01.util.MySessionFactory;
import org.hibernate.Session;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

/**
 * Created by yindp on 4/23/17.
 */
public class TestHQL {
    @Test
    public void testQueryAll() {
        Session session = null;
        try {
            session = MySessionFactory.openSession();
            List<Employee> employeeList = session.createQuery("from Employee").list();
            for (Employee employee : employeeList) {
                System.out.println(employee.getNickname() + ":" + employee.getDepartment().getName());
            }
            System.out.println("*****************************");
            Iterator<Employee> employeeIterator = employeeList.iterator();
            while (employeeIterator.hasNext()) {
                Employee employee = employeeIterator.next();
                System.out.println(employee.getNickname() + ":" + employee.getDepartment().getName());
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            MySessionFactory.close(session);
        }
    }

    @Test
    public void tesDepart() {
        Session session = null;
        try {
            session = MySessionFactory.openSession();
            List<Object[]> objectList = session.createQuery("select username,salary from Employee").list();
            for (Object[] obj : objectList) {
                System.out.println(obj[0] + ":" + obj[1]);
            }
            System.out.println("*************************************");
            Iterator<Object[]> it = objectList.iterator();
            while (it.hasNext()) {
                Object[] objects = it.next();
                System.out.println(objects[0] + ":" + objects[1]);
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            MySessionFactory.close(session);
        }


    }
}
