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
        Employee employee1 = new Employee("Ada", "333", "ada", 1000);
        Employee employee2 = new Employee("Tom", "222", "tom", 1000);
        Employee employee3 = new Employee("Sam", "123", "sam", 1000);
        Department department = new Department();
        department.setName("Finance");
        Set<Employee> employees = new HashSet<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        /*department.setEmployees(employees);*/
        Session session = null;
        try {
            session = MySessionFactory.openSession();
            session.beginTransaction();
            session.save(department);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MySessionFactory.close(session);
        }
    }
}
