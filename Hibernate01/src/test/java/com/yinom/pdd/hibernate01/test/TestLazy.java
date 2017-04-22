package com.yinom.pdd.hibernate01.test;

import com.yinom.pdd.hibernate01.bean.Employee;
import com.yinom.pdd.hibernate01.dao.impl.EmployeeDAOImpl;
import com.yinom.pdd.hibernate01.dao.inte.EmployeeDAOInte;
import com.yinom.pdd.hibernate01.util.MySessionFactory;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by yindp on 4/22/17.
 */
public class TestLazy {
    /**
     * "session.load" won't output sql sentence, and this is Hibernate lazy load.
     * It only shows sql when use System.out order to let it show.
     * The employee is just a proxy entity, and it just has id.
     */
    @Test
    public void testLoad01() {
        Session session = null;
        try {
            session = MySessionFactory.openSession();
            Employee employee = session.load(Employee.class, "ff8080815b9457be015b9457bf510000");
            System.out.println(employee);//It won't show sql sentence when we execute this sentence.
            System.out.println(employee.getId());//It also  won't show sql sentence when we execute this sentence, because the employee is just a proxy entity.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * "session.load" always show sql sentence, and it don't have lazy load.
     */
    @Test
    public void testGet01() {
        Session session = null;
        try {
            session = MySessionFactory.openSession();
            Employee employee = session.load(Employee.class, "ff8080815b9457be015b9457bf510000");
            System.out.println(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * "session.load" to query a record don't exist.
     */
    @Test
    public void testLoad02() {
        Session session = null;
        try {
            session = MySessionFactory.openSession();
            Employee employee = session.load(Employee.class, "11");
            //The entity with id is "11" don't exist in database table, so the below code will report error.
            //System.out.println(employee);
            //Because the employee is a proxy entity and it has id, so the below code will run correctly.
            System.out.println(employee.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGet02() {
        Session session = null;
        try {
            session = MySessionFactory.openSession();
            Employee employee = session.get(Employee.class, "11");
            //The next row code will run correctly and return "null".
            // System.out.println(employee);
            //Next row code will reporter error because there is not id "11" in database.
            System.out.println(employee.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * There will reporter an error "could not initialize proxy - no Session"
     *
     * session.load can be load lazy, but it only has id;
     * If we wanna get other attributes, we must query them in database, but the session closed when it return.
     *
     * When we use "session.get" and it will run correctly.
     *
     * The solution: we can use"session.get" to instead of "session.load" at this moment, or we can save  the session into ThreadLocal.
     */
    @Test
    public void testLazy() {
        Session session = null;
        try {
            EmployeeDAOInte employeeDAOInte = new EmployeeDAOImpl();
            Employee employee = employeeDAOInte.load("123");
            System.out.println(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
