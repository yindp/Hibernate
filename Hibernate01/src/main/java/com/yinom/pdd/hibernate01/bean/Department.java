package com.yinom.pdd.hibernate01.bean;

/**
 * Created by yindp on 4/22/17.
 */
public class Department {
    private String id;
    private String name;

    public Department() {

    }

    public Department(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

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
}
