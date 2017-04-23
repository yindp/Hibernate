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
    public void test() {
        Session session = null;
        try {
            session = MySessionFactory.openSession();
            String hql = "from Employee";
            List<Employee> employeeList = session.createQuery("from Employee").list();
            for (Employee employee : employeeList) {
                System.out.println(employee.getNickname()+":"+employee.getDepartment().getName());
            }
            System.out.println("*****************************");
            Iterator<Employee> employeeIterator = employeeList.iterator();
            while (employeeIterator.hasNext()) {
                Employee employee = employeeIterator.next();
                System.out.println(employee.getNickname()+":"+employee.getDepartment().getName());
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            MySessionFactory.close(session);
        }


    }
}
