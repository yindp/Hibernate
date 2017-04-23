package com.yinom.pdd.hibernate01.test;

import com.yinom.pdd.hibernate01.bean.Department;
import com.yinom.pdd.hibernate01.bean.Employee;
import com.yinom.pdd.hibernate01.util.MySessionFactory;
import org.hibernate.Session;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yindp on 4/22/17.
 */
public class OneToManyTest {
    @Test
    public void test() {
        Employee employee1 = new Employee("Ada1", "333", "ada1", 1000);
        Employee employee2 = new Employee("Tom1", "222", "tom1", 1000);
        Employee employee3 = new Employee("Sam1", "123", "sam1", 1000);
        Department department = new Department();
        department.setName("Finance111");
        Set<Employee> employees = new HashSet<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        department.setEmployeeSet(employees);
        Session session = null;
        try {
            session = MySessionFactory.openSession();
            session.beginTransaction();
            session.save(department);

            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            MySessionFactory.close(session);
        }
    }
}
