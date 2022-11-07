package com.example.courseproject.model;

/*
 * Created by IntelliJ IDEA.
 * Class: Examiner
 *
 * Author: DenysZhytariu
 * Version 1.0
 */

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Examiner {
    @Id
    public String id;
    public String fullName;
    public String subject;

    public Examiner() {
    }

    public Examiner(String fullName) {
        this.fullName = fullName;
    }

    public Examiner(String fullName, String subject) {
        this.fullName = fullName;
        this.subject = subject;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Examiner examiner = (Examiner) o;
        return id.equals(examiner.id) && fullName.equals(examiner.fullName) && subject.equals(examiner.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, subject);
    }

    @Override
    public String toString() {
        return "Examiner{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
