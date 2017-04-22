package com.yinom.pdd.hibernate01.test;

import com.yinom.pdd.hibernate01.bean.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;

/**
 * Created by yindp on 4/22/17.
 */
public class InitEmployeeTestFirst {
    @Test
    public void test() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        //2. 根据服务注册类创建一个元数据资源集，同时构建元数据并生成应用一般唯一的的session工厂
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        /****上面是配置准备，下面开始我们的数据库操作******/
        Session session = sessionFactory.openSession();//从会话工厂获取一个session

        session.beginTransaction();
        Employee employee = new Employee("Tom", "123", "tom", 1200);
        session.save(employee);
        session.getTransaction().commit();
        session.close();


    }
}
