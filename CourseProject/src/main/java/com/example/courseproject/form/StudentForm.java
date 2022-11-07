package com.example.courseproject.form;

/*
 * Created by IntelliJ IDEA.
 * Class: StudentForm
 *
 * Author: DenysZhytariu
 * Version 1.0
 */

public class StudentForm {
    public String id;
    public String firstName;
    public String lastName;
    public String specialty;

    public StudentForm() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "StudentForm{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialty='" + specialty + '\'' +
                '}';
    }
}
