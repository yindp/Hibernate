package com.yinom.pdd.hibernate01.test;

import com.yinom.pdd.hibernate01.bean.Department;
import com.yinom.pdd.hibernate01.bean.Employee;
import com.yinom.pdd.hibernate01.util.MySessionFactory;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by yindp on 4/22/17.
 */
public class ManyToOneTest {
    @Test
    public void test() {
        Session session = null;
        try {
            Employee employee = new Employee("Tim", "123", "tim", 800);
            Department department = new Department();
            department.setName("Finance");
            employee.setDepartment(department);
            session = MySessionFactory.openSession();
            session.beginTransaction();
            session.save(employee);
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
