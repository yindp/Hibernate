package com.yinom.pdd.hibernate01.bean;

import java.time.Period;

/**
 * Created by yindp on 4/23/17.
 */
public class IdCard {
    private String id;
    private String number;
    private Person person;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
