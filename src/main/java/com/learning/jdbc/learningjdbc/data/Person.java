package com.learning.jdbc.learningjdbc.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

import java.util.Date;

@Entity
@NamedQuery(name = "find_all_persons",query = "Select p from Person p")
public class Person {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String location;
    private Date birth_date;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirthDate() {
        return birth_date;
    }

    public void setBirthDate(Date birth_date) {
        this.birth_date = birth_date;
    }

    public Person(String name, String location, Date birth_date) {
        this.name = name;
        this.location = location;
        this.birth_date = birth_date;
    }

    public Person(int id, String name, String location, Date birth_date) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.birth_date = birth_date;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
          "id=" + id +
          ", name='" + name + '\'' +
          ", location='" + location + '\'' +
          ", birth_date=" + birth_date +
          '}';
    }
}
