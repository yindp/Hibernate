package com.yinom.pdd.hibernate01.bean;

/**
 * Created by yindp on 4/22/17.
 */
public class Employee {
    private String id;
    private String username;
    private String password;
    private String nickname;
    private double salary;
    private Department department;

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }

    public Employee(String id, String username, String password, String nickname, double salary, Department department) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.salary = salary;
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee() {

    }

    public Employee(String username, String password, String nickname, double salary) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.salary = salary;
    }

    public Employee(String id, String username, String password, String nickname, double salary) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
