package com.yinom.pdd.hibernate01.test;

import com.yinom.pdd.hibernate01.bean.Course;
import com.yinom.pdd.hibernate01.bean.StuCourse;
import com.yinom.pdd.hibernate01.bean.Student;
import com.yinom.pdd.hibernate01.util.MySessionFactory;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by yindp on 4/23/17.
 */
public class ManyToManyTest {
    @Test
    public void test() {
        Session session = null;
        try {
            session = MySessionFactory.openSession();
            session.beginTransaction();

            Student student = new Student();
            student.setName("LiBai");
            Course course = new Course();
            course.setName("Java");
            StuCourse stuCourse = new StuCourse();
            stuCourse.setGrade(99);
            stuCourse.setStudent(student);
            stuCourse.setCourse(course);

            session.save(student);
            session.save(course);
            session.save(stuCourse);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            MySessionFactory.close(session);
        }
    }
}
