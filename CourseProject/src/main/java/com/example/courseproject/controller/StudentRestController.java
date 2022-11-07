package com.example.courseproject.controller;

/*
 * Created by IntelliJ IDEA.
 * Class: StudentRestController
 *
 * Author: DenysZhytariu
 * Version 1.0
 */

import com.example.courseproject.model.Student;
import com.example.courseproject.service.impls.StudentServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {
    @Autowired
    StudentServiceImpls service;

    @GetMapping("/")
    List<Student> showAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    Student showOne(@PathVariable String id) {
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable String id) {
         service.delete(id);
    }

    @PostMapping("")
    Student createOne(@RequestBody Student student) {
        return service.create(student);
    }

    @PutMapping("")
    Student updateOne(@RequestBody Student student) {
        return service.update(student);
    }
}
