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

    @Test
    public void testUniqueResult() {
        Session session = null;
        try {
            session = MySessionFactory.openSession();
            /*Employee employee = (Employee) session.createQuery("from Employee where password=222").uniqueResult();
            System.out.println(employee);*/
            //Long count=(Long)session.createQuery("select count (*) from Employee").uniqueResult();
            int count = Integer.valueOf(session.createQuery("select count (*) from Employee").uniqueResult().toString());
            System.out.println(count);
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            MySessionFactory.close(session);
        }


    }

    @Test
    public void testDistinct() {
        Session session = null;
        try {
            session = MySessionFactory.openSession();
            List<String> list = session.createQuery("select distinct nickname from Employee").list();
            for (int i = 0; i < list.size(); i++) {
                String obj = list.get(i);
                System.out.println(obj);
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            MySessionFactory.close(session);
        }


    }

    @Test
    public void testBetweenAnd() {
        Session session = null;
        try {
            session = MySessionFactory.openSession();
            List<Employee> list = session.createQuery("from Employee where salary between 800 and 1000").list();
            for (int i = 0; i < list.size(); i++) {
                Employee employee = list.get(i);
                System.out.println(employee.getUsername() + ":" + employee.getSalary());
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            MySessionFactory.close(session);
        }


    }

    @Test
    public void testAvg() {
        Session session = null;
        try {
            session = MySessionFactory.openSession();
            Double avgSalary =(Double) session.createQuery("select avg(salary) from Employee").uniqueResult();
            System.out.println("Avg salary:"+avgSalary);
            Object[] salary = (Object[]) session.createQuery("select max (salary),min (salary) from Employee").uniqueResult();
            System.out.println("Max salary:"+salary[0]);
            System.out.println("Min salary:"+salary[1]);
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            MySessionFactory.close(session);
        }


    }
}
