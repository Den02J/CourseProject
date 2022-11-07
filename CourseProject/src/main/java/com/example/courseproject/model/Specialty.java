package com.example.courseproject.model;

/*
 * Created by IntelliJ IDEA.
 * Class: Specialty
 *
 * Author: DenysZhytariu
 * Version 1.0
 */

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Specialty {
    @Id
    public String id;
    public String name;
    public Subject subject1;
    public Subject subject2;
    public Subject subject3;

    public Specialty() {
    }

    public Specialty(String name, Subject subject1, Subject subject2, Subject subject3) {
        this.name = name;
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
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

    public Subject getSubject1() {
        return subject1;
    }

    public void setSubject1(Subject subject1) {
        this.subject1 = subject1;
    }

    public Subject getSubject2() {
        return subject2;
    }

    public void setSubject2(Subject subject2) {
        this.subject2 = subject2;
    }

    public Subject getSubject3() {
        return subject3;
    }

    public void setSubject3(Subject subject3) {
        this.subject3 = subject3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specialty specialty = (Specialty) o;
        return name.equals(specialty.name) && subject1.equals(specialty.subject1) && subject2.equals(specialty.subject2) && subject3.equals(specialty.subject3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, subject1, subject2, subject3);
    }

    @Override
    public String toString() {
        return "Specialty{" +
                "name='" + name + '\'' +
                ", subject1='" + subject1 + '\'' +
                ", subject2='" + subject2 + '\'' +
                ", subject3='" + subject3 + '\'' +
                '}';
    }
}
