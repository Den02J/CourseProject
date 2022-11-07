package com.example.courseproject.form;

/*
 * Created by IntelliJ IDEA.
 * Class: ExaminerForm
 *
 * Author: DenysZhytariu
 * Version 1.0
 */

import java.util.Objects;

public class ExaminerForm {
    public String id;
    public String examiner1;
    public String examiner2;
    public String examiner3;
    public String points1;
    public String points2;
    public String points3;

    public ExaminerForm() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExaminer1() {
        return examiner1;
    }

    public void setExaminer1(String examiner1) {
        this.examiner1 = examiner1;
    }

    public String getExaminer2() {
        return examiner2;
    }

    public void setExaminer2(String examiner2) {
        this.examiner2 = examiner2;
    }

    public String getExaminer3() {
        return examiner3;
    }

    public void setExaminer3(String examiner3) {
        this.examiner3 = examiner3;
    }

    public String getPoints1() {
        return points1;
    }

    public void setPoints1(String points1) {
        this.points1 = points1;
    }

    public String getPoints2() {
        return points2;
    }

    public void setPoints2(String points2) {
        this.points2 = points2;
    }

    public String getPoints3() {
        return points3;
    }

    public void setPoints3(String points3) {
        this.points3 = points3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExaminerForm that = (ExaminerForm) o;
        return id.equals(that.id) && examiner1.equals(that.examiner1) && examiner2.equals(that.examiner2) && examiner3.equals(that.examiner3) && points1.equals(that.points1) && points2.equals(that.points2) && points3.equals(that.points3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, examiner1, examiner2, examiner3, points1, points2, points3);
    }

    @Override
    public String toString() {
        return "ExaminerForm{" +
                "id='" + id + '\'' +
                ", examiner1='" + examiner1 + '\'' +
                ", examiner2='" + examiner2 + '\'' +
                ", examiner3='" + examiner3 + '\'' +
                ", points1='" + points1 + '\'' +
                ", points2='" + points2 + '\'' +
                ", points3='" + points3 + '\'' +
                '}';
    }
}
