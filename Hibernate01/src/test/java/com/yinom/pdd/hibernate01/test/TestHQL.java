package com.yinom.pdd.hibernate01.test;

import com.yinom.pdd.hibernate01.bean.Employee;
import com.yinom.pdd.hibernate01.bean.EmployeeDto;
import com.yinom.pdd.hibernate01.util.HibernateUtil;
import com.yinom.pdd.hibernate01.util.MySessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.*;

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
    public void testCommon() {
        Session session = null;
        try {
            session = MySessionFactory.openSession();
            Double avgSalary = (Double) session.createQuery("select avg(salary) from Employee").uniqueResult();
            System.out.println("Avg salary:" + avgSalary);
            Object[] salary = (Object[]) session.createQuery("select max (salary),min (salary) from Employee").uniqueResult();
            System.out.println("Max salary:" + salary[0]);
            System.out.println("Min salary:" + salary[1]);
            List<Employee> employeeList = session.createQuery("from employee group by department.id").list();
            for (Employee employee : employeeList) {
                System.out.println(employee);
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            MySessionFactory.close(session);
        }


    }

    @Test
    public void testPager() {
        Session session = null;
        try {
            session = MySessionFactory.openSession();
            List<Employee> employeeList = session.createQuery("from Employee order by salary").setFirstResult(0).setMaxResults(3).list();
            for (Employee employee : employeeList) {
                System.out.println(employee);
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            MySessionFactory.close(session);
        }
    }

    @Test
    public void testPagerPlus() {
        showResultByPager(4);

    }

    public void showResultByPager(int pageSize) {
        Session session = null;
        try {
            session = MySessionFactory.openSession();
            int currentPage = 1;
            int sumPage = 1;
            int sumRecord = 1;
            sumRecord = Integer.valueOf(session.createQuery("select count (*) from Employee").uniqueResult().toString());
            sumPage = (sumRecord - 1) / pageSize + 1;

            for (int i = 0; i < sumPage; i++) {
                System.out.println("*****************NO" + (i + 1) + " Page");
                List<Employee> employeeList = session.createQuery("from Employee").setFirstResult((i - 1) * pageSize).setMaxResults(pageSize).list();
                for (Employee employee : employeeList) {
                    System.out.println(employee);
                }
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            MySessionFactory.close(session);
        }
    }

    @Test
    public void testParameter() {
        Session session = null;
        try {
            session = MySessionFactory.openSession();
            List<Employee> employeeList = session.createQuery("from Employee order by salary").setFirstResult(0).setMaxResults(3).list();
            for (Employee employee : employeeList) {
                System.out.println(employee);
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            MySessionFactory.close(session);
        }
    }

    @Test
    public void testPara() {
        Session session = null;
        try {
            session = MySessionFactory.openSession();
            List<Employee> employeeList = session.createQuery("from Employee where salary >:s").setDouble("s", 800).list();
            for (Employee employee : employeeList) {
                System.out.println(employee);
            }
            System.out.println("*********************************");
            List<Employee> employeeList1 = session.createQuery("from Employee where salary between ? and?").setDouble(0, 800).setDouble(1, 1000).list();
            for (Employee employee : employeeList1) {
                System.out.println(employee);
            }
            System.out.println("********************************");
            Query query = session.createQuery("from Employee where salary > :s");
            query.setDouble("s", 800);
            List<Employee> employeeList2 = query.list();
            for (Employee employee : employeeList2) {
                System.out.println(employee);
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            MySessionFactory.close(session);
        }
    }

    @Test
    public void testQueryUtil01() {
        String hql = "from Employee where salary between ? and ?";
        String[] params = {"800", "1000"};
        List<Employee> employeeList = HibernateUtil.executeQuery(hql, params);
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    @Test
    public void testQueryUtil02() {
        String hql = "from Employee where salary between :s1 and :s2";
        Map<String, String> params = new HashMap<>();
        params.put("s1", "800");
        params.put("s2", "1000");
        List<Employee> employeeList = HibernateUtil.executeQuery(hql, params);
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    @Test
    public void testQueryUtil03() {
        String hql = "from Employee where salary between :s1 and :s2 order by salary";
        Map<String, String> params = new HashMap<>();
        params.put("s1", "800");
        params.put("s2", "1000");
        List<Employee> employeeList = HibernateUtil.executeQuery(hql, params, 3, 2);
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    @Test
    public void testQuery() {
        String hql = "select emp from Employee emp right join emp.department d where d.id=?";
        String[] params = new String[]{"1"};
        List<Employee> employeeList = HibernateUtil.executeQuery(hql, params);
        for (Employee em : employeeList) {
            System.out.println(em);
        }
    }

    @Test
    public void testQuery01() {
        String hql = "select emp.id,emp.username,emp.nickname,emp.salary,d.name from Employee emp right join emp.department d";
        List<Object[]> list = HibernateUtil.executeQuery(hql, new String[]{});
        for (Object[] objs : list) {
            System.out.println(objs[0]+":"+objs[1]+":"+objs[2]+":"+objs[3]+":"+objs[4]);
        }
    }
    @Test
    public void testQueryDTO() {
        String hql = "select new com.yinom.pdd.hibernate01.bean.EmployeeDto(emp.id,emp.username,emp.nickname,emp.salary,d.name)from Employee emp right join emp.department d";
        List<EmployeeDto> list = HibernateUtil.executeQuery(hql, new String[]{});
        for (EmployeeDto edto : list) {
            System.out.println(edto);
        }
    }
}
