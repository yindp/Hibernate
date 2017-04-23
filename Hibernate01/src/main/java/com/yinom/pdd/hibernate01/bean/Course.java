package com.yinom.pdd.hibernate01.bean;

import java.util.Set;

/**
 * Created by yindp on 4/23/17.
 */
public class Course {
    private String id;
    private String name;
    private Set<StuCourse> stuCourses;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<StuCourse> getStuCourses() {
        return stuCourses;
    }

    public void setStuCourses(Set<StuCourse> stuCourses) {
        this.stuCourses = stuCourses;
    }
}
