package com.yinom.pdd.hibernate01.bean;

/**
 * Created by yindp on 4/24/17.
 */
public class EmployeeDto {
    private String id;
    private String username;
    private String nickname;
    private double salary;
    private String deptName;

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", salary=" + salary +
                ", deptName='" + deptName + '\'' +
                '}';
    }

    public EmployeeDto() {

    }

    public EmployeeDto(String id, String username, String nickname, double salary, String deptName) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.salary = salary;
        this.deptName = deptName;
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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
