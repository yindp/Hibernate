package com.yinom.pdd.hibernate01.test;

import com.yinom.pdd.hibernate01.bean.Employee;
import com.yinom.pdd.hibernate01.util.MySessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;

/**
 * Created by yindp on 4/22/17.
 */
public class EmployeeTest {
    @Test
    public void testAdd() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        //2. 根据服务注册类创建一个元数据资源集，同时构建元数据并生成应用一般唯一的的session工厂
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        /****上面是配置准备，下面开始我们的数据库操作******/
        Session session = null;//从会话工厂获取一个session
        try {
            session = sessionFactory.openSession();

            session.beginTransaction();
            Employee employee = new Employee("Tom", "123", "tom", 1200);
            session.save(employee);
//            session.update(employee);
//            session.delete(employee);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    @Test
    public void testUpdate() {
        Session session = null;
        try {
            session = MySessionFactory.openSession();
            session.beginTransaction();
            Employee employee = session.load(Employee.class, "ff8080815b9457be015b9457bf510000");
            employee.setUsername("Eric");
            session.update(employee);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
                e.printStackTrace();
            }
        } finally {
            MySessionFactory.close(session);
        }


    }
}
