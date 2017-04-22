package com.yinom.pdd.hibernate01.dao.impl;

import com.yinom.pdd.hibernate01.bean.Employee;
import com.yinom.pdd.hibernate01.dao.inte.EmployeeDAOInte;
import com.yinom.pdd.hibernate01.util.MySessionFactory;
import org.hibernate.Session;

/**
 * Created by yindp on 4/22/17.
 */
public class EmployeeDAOImpl implements EmployeeDAOInte {
    @Override
    public Employee load(String id) {
        Session session = null;
        Employee employee = null;
        try {
            session = MySessionFactory.openSession();
            employee = session.load(Employee.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MySessionFactory.close(session);
        }
        return employee;

    }
}
