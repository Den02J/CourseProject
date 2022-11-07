package com.example.courseproject.model;

/*
 * Created by IntelliJ IDEA.
 * Class: Subject
 *
 * Author: DenysZhytariu
 * Version 1.0
 */

import java.util.Objects;

public class Subject {
    public String name;
    public Examiner examiner;
    public String points;

    public Subject() {
    }

    public Subject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Examiner getExaminer() {
        return examiner;
    }

    public void setExaminer(Examiner examiner) {
        this.examiner = examiner;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return name.equals(subject.name) && examiner.equals(subject.examiner) && points.equals(subject.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, examiner, points);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", examiner=" + examiner +
                ", points='" + points + '\'' +
                '}';
    }
}
